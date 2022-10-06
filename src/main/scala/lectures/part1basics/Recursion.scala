package com.raunakjodhawat
package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n, I need the factorial of ${n - 1}")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n, it's: ${result}")
      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, acc: BigInt): BigInt = {
      if (x < 1) acc
      else factorialHelper(x - 1, acc * x)
    }
    factorialHelper(n, 1)
  }

  factorial(10)
  println(anotherFactorial(200))

}
