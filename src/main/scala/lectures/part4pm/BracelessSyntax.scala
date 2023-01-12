package com.raunakjodhawat
package lectures.part4pm

object BracelessSyntax {
  // if expression
  val anIfExpression = if (2 > 3) "bigger" else "smaller"

  val anIfExpressionV3 =
    if (2 > 3) "bigger"
    else "smaller"

  // scala 3
  val anIfExpressionV4 =
    if 2 > 3 then "bigger"
    else "smaller"

  val anIfExpressionV5 =
    if 2 > 3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result

  println(anIfExpressionV5)
  // scala 3 one-liner
  val anIfExpressionV6 = if 2 > 3 then "bigger" else "smaller"

  // for comprehension
  val aForComprehension = for {
    n <- List(1, 2, 3)
    s <- List("Black", "while")
  } yield s"$n-$s"

  // scala 3
  val aForComprehensionV2 =
    for
      n <- List(1, 2, 3)
      s <- List("Black", "while")
    yield s"$n-$s"

  val meaningOfLife = 42
  val aPatternMatch = meaningOfLife match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case _ => "something else"
  }

  val aPatternMatchV2 =
    meaningOfLife match
      case 1 => "the one"
      case 2 => "double or nothing"
      case _ => "something else"

  // methods without braces
  def computeMeaningOfLife(arg: Int): Int =
    val partialResult = 40

    partialResult + 2

  // class definition (same for traits, objects, enums)
  class Animal: // Compiler expects the body of Animal
    def eat(): Unit =
      println("I am eating")
    end eat

    def grow(): Unit = println("I am growing")

  end Animal // for if, match, for, methods, classes, traits, enums, objects

  // anonymous classes
  val aSpecialAnimal = new Animal:
    override def eat(): Unit = println("I'm eating")

  // indendation = strictly larger indentation

  def main(args: Array[String]): Unit = {
    println(computeMeaningOfLife(23))
  }
}
