package com.raunakjodhawat
package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat(): Unit
  }

  // anonymous class
  val funnyAnimal = new Animal {
    override def eat(): Unit = println("hahaha")
  }

  class Person(name: String) {
    def sayHi(): Unit = println(s"Hi, my name is $name. How can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi(): Unit = println(s"Hi, my name is Jim. How can I help?")
  }

  jim.sayHi()

}
