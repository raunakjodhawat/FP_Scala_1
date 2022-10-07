package com.raunakjodhawat
package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Raunak", 28)
  println(person.age)
}
// constructor
class Person(name: String, val age: Int) {
  // body

}

// class parameters are not fields
