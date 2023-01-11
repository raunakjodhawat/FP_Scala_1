package com.raunakjodhawat
package lectures.part3functionalprogramming

import scala.util.Random

object Sequences extends App {
  // Seq
  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)
  val ordering = Ordering[Int]((x, y) => y - x)
  println(aSequence.sorted(ordering))

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  // List
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 89
  println(4 +: aList)
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Float](3)
  println(threeElements.mkString(", "))
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(", "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // vector
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vector vs list
  val maxRuns = 1000
  val maxCapacity = 100000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      _ <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / times.length / 1000
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps refrence to tail
  // updating element in middle takes a long time
  println(s"List test: ${getWriteTime(numbersList)} ms")

  // depth of tree is small
  // vector needs to replace an entire 32 element check
  println(s"Vector test: ${getWriteTime(numbersVector)} ms")

}
