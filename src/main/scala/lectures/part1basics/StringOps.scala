package com.raunakjodhawat
package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)
  val aNumberString: String = "2"
  val aNumber: Int = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // scala specific things

  // string interpolators

  // s interpolator
  val name: String = "Raunak"
  val age: Int = 28
  val greeting: String = s"Hello, my name is $name and my age is $age"
  println(greeting)
  val anotherGreeting: String =
    s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

  // f interpolator
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f"
  println(myth)

  // raw interpolator

  println(raw"This is a \n new Line")

  val escaped = "This is a \n new Line"
  println(raw"$escaped")
}
