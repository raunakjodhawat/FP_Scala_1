package com.raunakjodhawat
package lectures.part2oop

object Generics extends App {
  // generic class, A => Type parameters
  // generic traits
  class MyList[A] {}

  class MyMap[Key, Value] {}
  val listOfIntegers = MyList[Int]
  val listOfStrings = MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
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
  // animalList.add(dog) ??? Hard question

  // option 2: no list of cats can not extend list of animal (in-variance)
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // option 3: Hell no (contra-variance)
  class ContraVariantList[-A]
  val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
}
