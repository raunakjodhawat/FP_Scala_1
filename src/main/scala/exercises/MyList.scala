package com.raunakjodhawat
package exercises

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  override def toString: String
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(i: Int): MyList = new Cons(i, Empty)
  override def toString: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  override def toString: String =
    if (t.isEmpty) h.toString else h + "->" + t.toString
}

object Tester extends App {
  val myList = Cons(1, Cons(2, Cons(3, Empty)))
  println(myList)

}
