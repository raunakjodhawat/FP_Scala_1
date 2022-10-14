package com.raunakjodhawat
package lectures.part2oop

import playground.{PrinceCharming, Cindrella as Princess}

import java.util.{Date => JavaUtilDate}
import java.sql.{Date => JavaSQLDate}

object PackagingAndImports extends App {
  // package member can be accessed with their simple names
  val writer = new Writer("Rock", "Rock the JVM", 2018)
  val cindrella_1 = new Princess
  println(cindrella_1)

  // packages are ordered hiereachically
  // matching folder structure

  // package object
  hello()
  println(SPEED_OF_LIGHT)

  // imports
  val princeCharming = new PrinceCharming

  // 1. Use fully qualified name
  // val date = JavaUtilDate

  // 2. Use aliasing

  // default imports

  // scala.predef => println, ???

}
