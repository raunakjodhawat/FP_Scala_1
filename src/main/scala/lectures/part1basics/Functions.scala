package com.raunakjodhawat
package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = a + " " + b

  println(aFunction("hello", 3))

  def aParameterLessFunction: Int = 42

  println(aParameterLessFunction)

  def aRepeatedFunction(a: String, times: Int): String = {
    if (times == 1) {
      a
    } else {
      a + aRepeatedFunction(a, times - 1)
    }
  }

  println(aRepeatedFunction("hello", 3))

  // When you need loops, use recursion

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  println(aFunctionWithSideEffects("hello"))

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }

  // Exercises

  def greet(name: String, age: Int): Unit = println(
    s"Hi my name is ${name} and I am ${age} years old"
  )

  def fact(n: Int): Int = {
    if (n <= 0) 1
    else n * fact(n - 1)
  }

  def fibo(n: Int): Int = {
    if (n <= 2) 1
    else fibo(n - 1) + fibo(n - 2)
  }

  def isPrime(n: Int): Boolean = {
    def loop(m: Int): Boolean = {
      if (m == n) true
      else if (n % m == 0) false
      else loop(m + 1)
    }
    loop(2)
  }
  println(greet("Raunak", 29))
  println(fact(1))
  println(fact(2))
  println(fact(3))
  println(fact(4))

  println(fibo(1))
  println(fibo(2))
  println(fibo(3))
  println(fibo(4))

  println(isPrime(22))
}
