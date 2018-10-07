package com.aleksandrbogomolov.gameoflife

class Universe(width: Int, height: Int) {

  val structure: Array[Array[Cell]] = Array.ofDim(width, height)

  def printStructure(): Unit = for {
    i <- 0 until width
    j <- 0 until height
  } yield {
    print(structure(i)(j) + " ")
    if (j == width - 1) println()
  }
}

object Universe {

  def apply(width: Int, height: Int): Universe = new Universe(width, height)
}
