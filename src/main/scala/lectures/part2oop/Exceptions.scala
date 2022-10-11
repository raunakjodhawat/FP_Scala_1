package com.raunakjodhawat
package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  // println(x.length) // this will crash!

  // 1. throwing and catching exceptions
  // val aWeirdValue = throw new NullPointerException()

  // throwable classes extend the Throwable class
  // Exceptions and Errors are the major Throwable sub-types

  // 2. Catching exceptions!

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int! for you") else 42

  val potentialFail =
    try {
      getInt(false)
    } catch {
      case e: RuntimeException => 43
    } finally {
      // Finally block is optional. Also, it does not influence the return type
      // Use finally only for side effects
      println("Will get executed, no matter what")
    }
  println(potentialFail)

  // define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  // throw exception

  // Exceptions

  object OverFlowException extends Exception
  object UnderFlowException extends Exception
  object MathCalculationException extends Exception

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw UnderFlowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw OverFlowException
      else if (x > 0 && y < 0 && result > 0) throw UnderFlowException
      else if (x < 0 && y > 0 && result > 0) throw UnderFlowException
      else result
    }

    def divide(x: Int, y: Int): Double =
      if (y == 0) throw MathCalculationException else x / y
  }

  // println(PocketCalculator.add(Int.MaxValue, 10))

}
