package com.raunakjodhawat
package lectures.part3functionalprogramming

import scala.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // unsafe API's
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod()) // wrong
  val result = Option(unsafeMethod())
  println(result)

  // chained methods
  def backupMethod(): String = "A Valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  // design unsafe API's
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterChainedResult)

  println(noOption.isEmpty)
  println(myFirstOption.get) // unsafe - do not use

  println("map, filter, flatmap")
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ == 1))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehension
  // exercises

  val config: Map[String, String] = Map(
    "host" -> "172.12.32.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) {
        Some(new Connection)
      } else {
        None
      }
    }
  }

  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // chained calls
  config
    .get("host")
    .flatMap(h =>
      config
        .get("port")
        .flatMap(p =>
          Connection(h, p)
            .map(c => c.connect)
        )
    )
    .foreach(println)

  // for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  println(forConnectionStatus)
  forConnectionStatus.foreach(println)
}
