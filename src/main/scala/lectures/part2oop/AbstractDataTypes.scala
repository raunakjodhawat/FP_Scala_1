package com.raunakjodhawat
package lectures.part2oop

object AbstractDataTypes extends App {
  // abstract members
  // abstract classes

  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "K9"
    def eat: Unit = println("crunch, crunch")
  }

  // traits
  trait Carnivore(name: String) {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh Meat"
  }

  trait ColdBlooded {}
  class Crocodile(name: String = "raunak")
      extends Animal
      with Carnivore(name)
      with ColdBlooded {
    override val creatureType: String = "K9"
    def eat: Unit = println("nom nom")
    def eat(animal: Animal): Unit = println(
      s"I am a Croc, and I am eating ${animal.creatureType}"
    )
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  // trait and abstract classes
  // both can have both abstract and non-abstract members and methods
  // traits do not have constructor parameters
  // multiple traits may be inherited by the same class
  // traits are behaviour, abstract class is a type of thing
}
