package com.raunakjodhawat
package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  override def toString: String
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[A](i: A): MyList[A] = new Cons(i, Empty)
  override def toString: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  override def toString: String =
    if (t.isEmpty) h.toString else h.toString + "->" + t.toString
}

object Tester extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, Empty))
  val listOfStrings: MyList[String] =
    new Cons("Hello", new Cons("world", new Cons("scala", Empty)))
  println(listOfIntegers)
  println(listOfStrings)

}
