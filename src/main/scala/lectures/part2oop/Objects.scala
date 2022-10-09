package com.raunakjodhawat
package lectures.part2oop

object Objects extends App {
  // Scala does not have class level functionality
  // Scala does not have static
  object Person { // type +its only instance
    // static or class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Boby")
  }
  class Person(val name: String) {
    // instance level functionality
  }
  // companions (class and object with same name in same scope)

  // objects do not receive parameters
  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object is a singleton instance
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobby = Person(mary, john)

  // Scala applications = Scala object with
  // def main(args: Array[String]): Unit
}
