package com.raunakjodhawat
package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favMovie
    def +(p: Person): String = s"$name is hanging out with ${p.name}"
    def +(s: String): Person = new Person(s"$name ($s)", favMovie)
    def unary_! : String = s"$name, what the heck!"
    def unary_+ : Person = new Person(name, favMovie, age + 1)
    def isAlive: Boolean = true
    def learns(s: String): String = s"$name learns $s"
    def learnScala: String = this learns "Scala"
    def apply(): String = s"Hi, my name is $name and I like $favMovie"
    def apply(i: Int): String =
      s"$name watched their favorite movie: $favMovie, $i times"
  }

  val mary = new Person("Mary", "inception")
  println(mary.likes("inception"))
  println(mary likes "inception")
  // infix notation or operator notation (Syntactic sugar)
  // (only work with methods with one parameter)

  // "operators" in scala
  val tom = new Person("Tom", "fight club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // all operators are methods

  // akka operators are methods ? !

  // prefix notation

  val x = -1 // equivalent to 1.unary_-
  val y = 1.unary_-

  // unary_-nly wirks with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)

  // apply
  println(mary.apply())
  println(mary())

  // Exercises
  println(mary.learnScala)
  println((+mary).age)
}
