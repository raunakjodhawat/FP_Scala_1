package com.raunakjodhawat
package lectures.part1basics

object Expressions extends App {
  val x =
    1 + 2 // Expressions, expressions are evaluated to a value and it's type
  println(x)

  println(
    2 + 3 * 4
  ) // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x) // == != > >= < <=

  println(!(1 == x)) // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /=

  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)
  // if expression

  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // if expression
  println(aConditionValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // everything in scala is an expression

  val aWeirdValue = (aVariable = 3) // unit == void

  println(aWeirdValue)

  // side effects in scala is expressions returning a unit
  // ex: println, val's, reassignment of val/var

  // code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

}
