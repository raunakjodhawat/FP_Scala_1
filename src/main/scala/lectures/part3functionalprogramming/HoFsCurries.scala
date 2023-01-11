package com.raunakjodhawat
package lectures.part3functionalprogramming

import scala.annotation.tailrec

object HoFsCurries extends App {

  // higher order functions (eg. map, flatmap & filter)
//  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) =
//    ???

  // function that applies a function n times over a value x
  // nTimes(f, n, x)

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // curried functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y

  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  // Exercises
  /**   1. expand MyList
    *   - foreach method A => Unit
    *   - sort function ((A, A) => Int) => MyList
    *   - zipWith (list, (A, A) => B) => MyList[B]
    *   - fold
    *
    * 2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
    *
    * fromCurry(f: (Int=> Int => Int)) => (Int, Int) => Int
    *
    * 3. compose(f, g) => x => f(g(x)) andThen(f, g) => x => g(f(x))
    */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = { (x: Int) =>
    f(x, _)
  }

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int = f(_)(_)

  // FunctionX
  def compose[A, B, T](f: A => B, g: T => A): T => B = (x: T) => f(g(x))

  def andThen[A, B, C](f: A => B, g: B => C): A => C = (x: A) => g(f(x))

  def supperAdder2: Int => Int => Int = toCurry(_ + _)
  def add4 = supperAdder2(4)
  println(add4(17))

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4, 17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))
}
