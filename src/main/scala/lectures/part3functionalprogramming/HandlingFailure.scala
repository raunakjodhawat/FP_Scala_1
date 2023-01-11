package com.raunakjodhawat
package lectures.part3functionalprogramming

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {
  // create success and failure
  val aSucess = Success(3)
  val aFailure = Failure(new RuntimeException("Super failure"))

  println(aSucess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String for you")

  // try objects
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A Valid result"
  val fallBackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))

  println(fallBackTry)

  // if you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("Hello"))
  def betterBackupMethod(): Try[String] = Success("Better result")
  val betterFallback = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterFallback)

  // map, filter, flatmap
  println(aSucess.map(_ * 2))
  println(aSucess.flatMap(x => Success(x * 10)))
  println(aSucess.filter(_ == 1))

  // exrcise
  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(
      getConnection(host, port)
    )
  }

  HttpService
    .getSafeConnection(hostname, port)
    .flatMap(c => c.getSafe(""))
    .foreach(renderHTML)

  println("bottom")
  for {
    c <- HttpService.getSafeConnection(hostname, port)
    html <- c.getSafe("")
  } renderHTML(html)
}
