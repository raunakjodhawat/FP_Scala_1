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

  val network: Map[String, List[String]] =
    Map().withDefaultValue(List[String]())
  def addAPersonToNetwork(
      name: String,
      net: Map[String, List[String]]
  ): Map[String, List[String]] =
    net + (name -> List[String]())

  def removeAPersonFromNetwork(
      name: String,
      net: Map[String, List[String]]
  ): Map[String, List[String]] =
    net - name

  def connectFriends(
      name1: String,
      name2: String,
      net: Map[String, List[String]]
  ): Map[String, List[String]] = {
    if (net.contains(name1) && net.contains(name2)) {
      net + (name1 -> (net(
        name1
      ) :+ name2)) + (name2 -> (net(name2) :+ name1))
    } else {
      net
    }
  }

  def removeFriend(
      name1: String,
      name2: String,
      net: Map[String, List[String]]
  ): Map[String, List[String]] = {
    if (net.contains(name1) && net.contains(name2)) {
      net + (name1 -> net(
        name1
      ).filter(_ != name2)) + (name2 -> net(name2).filter(_ != name1))
    } else {
      net
    }
  }

  def numberOfFriendsOfAPerson(
      name: String,
      net: Map[String, List[String]]
  ): Int = net(name).length
  def personsWithMostFriends(net: Map[String, List[String]]): String =
    net.maxBy(pair => pair._2.size)._1

  def countOfPeopleWithNoFriends(net: Map[String, List[String]]): Int =
    net.count(_._2.isEmpty)

  def areTwoPeopleConnected(
      name1: String,
      name2: String,
      net: Map[String, List[String]]
  ): Boolean = {
    def bfs(
        target: String,
        consideredPeople: List[String],
        discoveredPeople: List[String]
    ): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person))
          bfs(target, consideredPeople, discoveredPeople.tail)
        else
          bfs(
            target,
            consideredPeople :+ person,
            discoveredPeople.tail ++ net(person)
          )
      }
    }
    bfs(name2, List(), net(name1) :+ name1)
  }
}
