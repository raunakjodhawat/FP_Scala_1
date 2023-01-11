package com.raunakjodhawat
package lectures.part3functionalprogramming

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists"
  val aTuple = (2, "Hello Scala")
  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  // Maps - Keys -> values association
  val aMap: Map[String, Int] = Map()
  val phoneBook =
    Map(("Raunak" -> 111), ("Jodhawat" -> 222)).withDefaultValue(-1)
  // a -> b is syntatic sugar for (a, b)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Raunak"))
  println(phoneBook("Raunak"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // functionals on map
  // map, flatmap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.view.filterKeys(_.startsWith("R")).toMap)

  // mapValues
  println(phoneBook.view.mapValues(number => "+91- " + number).toMap)

  // conversion to other collection
  println(phoneBook.toList)
  println(List(("R" -> 111)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  // exercises
  val phoneBookWithCollision: Map[String, Int] =
    Map(("Jim" -> 111), ("JIM" -> 999))
  println(phoneBookWithCollision.map(p => (p._1.toLowerCase -> p._2)))
}
