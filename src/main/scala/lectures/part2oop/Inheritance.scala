package com.raunakjodhawat
package lectures.part2oop

object Inheritance extends App {
  // scala offers single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat(): String = "nom, nom, nom"
  }

  class Cat extends Animal {
    def crunch() = {
      println("crunch crunch")
      eat()
    }

  }

  val cat = new Cat
  println(cat.crunch())

  // constructors

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat(): String = {
      super.eat() + "crunch, crunch"
    }
  }
  val dog = new Dog("Domestic")
  println(dog.eat())
  println(dog.creatureType)

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("k9")
  println(unknownAnimal.eat())

  // overRiding (different implementation in derived classes) vs overLoading (multiple methods with different signature, with same name and same class)

  // super

  // preventing overrides
  // final on methods or class
  // seal the class = extend classes in this file, but prevents extension in other files

}
