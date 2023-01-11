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

  // hofs
  def foreach(f: A => Unit): Unit
  def sort(f: (A, A) => Int): MyList[A]
  def zipWith[B >: A](l: MyList[B], f: (B, A) => B): MyList[B]
  def fold[B >: A](acc: B)(f: (B, A) => B): B
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

  // hofs
  def foreach(f: Nothing => Unit): Unit = ()
  override def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  override def zipWith[B >: Nothing](
      l: MyList[B],
      f: (B, Nothing) => B
  ): MyList[B] = if (!l.isEmpty)
    throw new Exception("Lists do not have same length")
  else Empty
  override def fold[B >: Nothing](acc: B)(f: (B, Nothing) => B): B = acc

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

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B >: A](l: MyList[B], f: (B, A) => B): MyList[B] =
    l match {
      case Cons(x, y) => Cons(f(x, h), t.zipWith(y, f))
    }

  override def fold[B >: A](acc: B)(f: (B, A) => B): B = t.fold(f(acc, h))(f)

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

  println(listOfIntegers.map(_ * 10))
  println(listOfIntegers.filter(_ % 2 == 0))
  println(listOfIntegers.flatMap(x => Cons(x, Cons(x * 10, Empty))))

  listOfIntegers.foreach(println(_))
  println(listOfIntegers.sort((x: Int, y: Int) => y - x))
  println(
    listOfIntegers.zipWith(Cons(4, Cons(3, Cons(2, Cons(1, Empty)))), _ * _)
  )
  println(listOfIntegers.fold(0)(_ + _))

  println(for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + " - " + string)
}
