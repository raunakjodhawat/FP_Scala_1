package com.raunakjodhawat
package lectures.part3functionalprogramming

object MapFlatMapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  println(list.filter(_ % 2 == 0))
  println(list)

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  println(for {
    i <- numbers if i % 2 == 0
    j <- chars
  } yield s"$j$i")

  // iterations
  println(chars.flatMap(x => numbers.map(y => s"$x$y")))

  // foreach
  list.foreach(println)

  // for-comprehensions
  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /**   1. Mylist supports for comprehensions 2. A small collection of at most
    *      one element - Maybe[+T]
    *      - map, flatmap, filter
    */

}
