package com.raunakjodhawat
package lectures.part3functionalprogramming

object AnonymousFunctions extends App {

  val doubler: Int => Int = _ * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething)
  println(justDoSomething())

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // more syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  // Exercises
}
