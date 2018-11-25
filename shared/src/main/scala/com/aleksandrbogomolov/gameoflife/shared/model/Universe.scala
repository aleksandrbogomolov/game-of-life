package com.aleksandrbogomolov.gameoflife.shared.model

case class Universe(width: Int, height: Int) { //TODO convert to single param size

  val structure: Array[Array[Cell]] = Array.ofDim(width, height)

  val init: Unit = for (x <- 0 until width; y <- 0 until height) yield structure(x)(y) = Cell(x, y, Alive())

  def calcNeighbors(cell: Cell): Int = {
    ???
  }

  def setCell(stringId: String): Unit = {
    val coordinate = stringId.split(":")
    val x = coordinate(0).toInt
    val y = coordinate(1).toInt
    structure(x)(y) = Cell(x, y, Alive())
  }

  def xOutOfRange(x: Int): Boolean = x < 0 || x >= width

  def yOutOfRange(y: Int): Boolean = y < 0 || y >= height

  def printStructure(): Unit = for {
    i <- 0 until width
    j <- 0 until height
  } yield {
    print(structure(i)(j) + " ")
    if (j == width - 1) println("|")
  }
}
