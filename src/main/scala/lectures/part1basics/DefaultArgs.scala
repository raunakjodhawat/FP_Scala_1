package com.raunakjodhawat
package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFactorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFactorial(n - 1, n * acc)
  }

  val fact10 = trFactorial(10)

  def savePicture(
      fmt: String = "jpeg",
      width: Int = 400,
      height: Int = 1080
  ): Unit = {
    println("Saving picture")
  }

  savePicture(height = 600, width = 800, fmt = "bitmap")

}
