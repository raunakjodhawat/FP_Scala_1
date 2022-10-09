package com.raunakjodhawat
package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Raunak", 28)
  println(person.x)

  println(person.greet("Jodhawat"))
  println(person.greet())
}
// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(2 + 2)

  def greet(name: String): Unit = {
    println(s"${this.name} says hi: $name")
  }

  // overloading (same name, but different signature)
  def greet(): Unit = {
    println(s"Hi, i am $name")
  }

  // multiple constructors

  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

// class parameters are not fields
