package com.raunakjodhawat
package lectures.part2oop

object CaseClasses extends App {

  /** equals, hashCode, toString
    */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to field

  val jim = Person("Jim", 34)
  println(jim.name)

  // 2. A sensible toString
  println(jim)

  // 3. equals and hashCode implemented out of the box
  val jim_2 = Person("Jim", 34)
  println(jim == jim_2)

  // 4. case classes handy copy methods
  val jim_3 = jim.copy(age = 45)

  println(jim_3)

  // 5. Case classes have companion object
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CC are serializable (Akka)

  // 7. CC have extractor pattern (Pattern Matching)

  case object UnitedKingdom {
    def name: String = "The UK of great Britian, Northern Ireland & Scotland"
  }
}
