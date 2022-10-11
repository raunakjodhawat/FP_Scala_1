package com.raunakjodhawat
package exercises

import scala.annotation.targetName

trait MyPredicate[-T] {
  def test(a: T): Boolean
}

class EvenPredicate extends MyPredicate[Int] {
  override def test(a: Int): Boolean = a % 2 == 0
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}

class StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(a: String): Int = a.toInt
}

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def map[B](a: MyTransformer[A, B]): MyList[B]
  def filter(a: MyPredicate[A]): MyList[A]
  def flatMap[B](a: MyTransformer[A, MyList[B]]): MyList[B]
  def ++[B >: A](list: MyList[B]): MyList[B]
  override def toString: String
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[A](i: A): MyList[A] = Cons(i, Empty)
  def map[B](a: MyTransformer[Nothing, B]): MyList[B] = Empty
  def filter(a: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def flatMap[B](a: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  override def toString: String = ""
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = Cons(element, this)

  def map[B](a: MyTransformer[A, B]): MyList[B] =
    Cons(a.transform(h), t.map(a))
  def filter(a: MyPredicate[A]): MyList[A] = if (a.test(h)) {
    Cons(h, t.filter(a))
  } else {
    t.filter(a)
  }
  def flatMap[B](a: MyTransformer[A, MyList[B]]): MyList[B] =
    a.transform(h) ++ t.flatMap(a)

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)
  override def toString: String =
    if (t.isEmpty) h.toString else h.toString + "->" + t.toString
}

object Tester extends App {
  val listOfIntegers: MyList[Int] =
    Cons(1, Cons(2, Cons(3, Cons(4, Empty))))

  val listOfIntegersClone: MyList[Int] =
    Cons(1, Cons(2, Cons(3, Cons(4, Empty))))

  println(listOfIntegers == listOfIntegersClone)
  val listOfStrings: MyList[String] =
    Cons("Hello", Cons("world", Cons("scala", Empty)))
  println(listOfIntegers)
  println(listOfStrings)

  println(listOfIntegers.map(x => x * 10))
  println(listOfIntegers.filter(x => x % 2 == 0))
  println(listOfIntegers.flatMap(x => Cons(x, Cons(x * 10, Empty))))
}
