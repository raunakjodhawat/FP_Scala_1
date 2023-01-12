package com.raunakjodhawat
package lectures.part4pm

import exercises.{MyList, Cons, Empty}

object AllThePatterns extends App {
  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1              => "A number"
    case "string"       => "The scala"
    case true           => "the truth"
    case AllThePatterns => "A singleton object"
    case _              => "anything"
  }

  // 2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ => "hello"
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1)         => "hi"
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) => s"I've found $v"
  }
  // PMs can be nested

  // 4 - case classes - constructor pattern
  // PM can be nested with case classes as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty                              => "empty list"
    case Cons(head, Cons(subhead, subtail)) => s"${subhead}"
  }

  // 5 - list patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _)    => "hello"
    case List(1, _*)         => "List of arbitary length"
    case 1 :: List(_)        => "infix pattern"
    case List(1, 2, 3) :+ 42 => "infix pattern"
  }

  // 6 - type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "explicit type specifier"
    case _               => "not a List[Int]"
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => s"use the name later ${nonEmptyList}"
    case Cons(1, rest @ Cons(2, _)) =>
      s"name binding insdie nested pattern $rest"
  }
  println(nameBindingMatch)

  // 8 - multi pattern
  val multiPattern = aList match {
    case Empty | Cons(0, _) => "Compound pattern"
    case _                  => "wild card"
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
      "second element is even"
    case _ => "wild card"
  }

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfString: List[String] => "a list of string"
    case listOfInt: List[Int]       => "a list of integers"
    case _                          => ""
  }
  println(numbersMatch) // JVM trick question
}
