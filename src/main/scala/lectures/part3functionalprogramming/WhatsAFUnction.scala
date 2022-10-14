package com.raunakjodhawat
package lectures.part3functionalprogramming

object WhatsAFUnction extends App {
  // Function as first class elements
  println("hello world")

  val doubler = new MyFunction[Int, Int] {
    override def apply(i: Int): Int = i * 2
  }
  println(doubler(2))

  // function types = Function1[A, B] .... Function23[A,...]
  val stringToIntConvertor = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConvertor("100") + 7)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // function types Function2[A, B, R] === (A, B) => R
  println(adder(1, 2))

  // All scala functions are objects

  // exercises
  val concatenate: (String, String) => String =
    new Function2[String, String, String] {
      override def apply(v1: String, v2: String): String = v1 + v2
    }

  println(concatenate("hello", "world"))

  val supperAdder: Function1[Int, Function1[Int, Int]] =
    new Function1[Int, Function1[Int, Int]] {
      override def apply(v1: Int): Function1[Int, Int] =
        new Function1[Int, Int] {
          override def apply(v2: Int): Int = v1 + v2
        }
    }

  val specialFunction_1: Int => Int => Int = (x: Int) => (y: Int) => x + y

  val adder3 = supperAdder(3)
  println(adder3(4))
  println(supperAdder(3)(4))

}

trait MyFunction[A, B] {
  def apply(i: A): B
}
