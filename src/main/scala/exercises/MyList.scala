package com.raunakjodhawat
package exercises

import scala.annotation.targetName

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]

  // higher-order functions
  // They receive either functions as parameters or returns functions
  def map[B](a: A => B): MyList[B]
  def filter(a: A => Boolean): MyList[A]
  def flatMap[B](a: A => MyList[B]): MyList[B]
  def ++[B >: A](list: MyList[B]): MyList[B]
  override def toString: String
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[A](i: A): MyList[A] = Cons(i, Empty)
  def map[B](a: Nothing => B): MyList[B] = Empty
  def filter(a: Nothing => Boolean): MyList[Nothing] = Empty
  def flatMap[B](a: Nothing => MyList[B]): MyList[B] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  override def toString: String = ""
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = Cons(element, this)

  def map[B](a: A => B): MyList[B] =
    Cons(a(h), t.map(a))
  def filter(a: A => Boolean): MyList[A] = if (a(h)) {
    Cons(h, t.filter(a))
  } else {
    t.filter(a)
  }
  def flatMap[B](a: A => MyList[B]): MyList[B] =
    a(h) ++ t.flatMap(a)

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
