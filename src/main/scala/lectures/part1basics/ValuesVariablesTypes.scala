package com.raunakjodhawat
package lectures.part1basics

object ValuesVariablesTypes {
  val x: Int = 42
  println(x)

  // VALS are immutable

  // COMPILER can infer types

  val aString: String = "Hello, this is a string!"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 123
  val aLong: Long = 1231231231231231L
  val aFloat: Float = 2.0
  val aDouble: Double = 3.5

  // variables

  var aVariable: Int = 4
  aVariable = 5 // side effects
  println(aVariable)
}
