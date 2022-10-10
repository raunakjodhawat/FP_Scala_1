package com.raunakjodhawat
package lectures.part2oop

import scala.runtime.Nothing$

object Generics extends App {
  // generic class, A => Type parameters
  // generic traits
  class MyList[+A] {

    def add[B >: A](element: B): MyList[B] = null
  }

  class MyMap[Key, Value] {}
  val listOfIntegers = MyList[Int]
  val listOfStrings = MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = null
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // option 1: yes list of cats extends list of animal (co-variance)
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(dog) ??? Hard question => we return list of animals

  // option 2: no list of cats can not extend list of animal (in-variance)
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // option 3: Hell no (contra-variance)
  class ContraVariantList[-A]
  val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // 1. Upper bounded types
  class Cage[A <: Animal](
      animal: A
  ) // Will accept types which is subtype of animal

  val cage = new Cage(new Dog)

  class Car
  val cage_1 = new Cage(new Animal)

  // 2. Lower bounded types
  // A >: Animal

}
