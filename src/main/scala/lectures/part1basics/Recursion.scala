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

  // Exercises

  def concatenate(str: String, n: Int): String = {
    @tailrec
    def loop(s: String, m: Int): String = {
      if (m < n - 1) {
        loop(s + str, m + 1)
      } else {
        s
      }
    }
    loop(str, 0)
  }
  println(concatenate("hello", 3))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def loop(m: Int): Boolean = {
      if (m < n / 2) {
        if (n % m == 0) {
          false
        } else {
          loop(m + 1)
        }
      } else true
    }
    loop(2)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 2) {
      1
    } else {
      @tailrec
      def loop(f: Int, s: Int, counter: Int): Int = {
        if (counter == n) {
          f + s
        } else {
          loop(s, f + s, counter + 1)
        }
      }
      loop(1, 1, 3)
    }
  }

  println(isPrime(23))

  println(fibonacci(8))
}
