package com.aleksandrbogomolov.gameoflife.shared.model

case class Universe(width: Int, height: Int) {

  val structure: Array[Array[Cell]] = Array.ofDim(width, height)

  val init: Unit = for (x <- 0 until width; y <- 0 until height) yield structure(x)(y) = Cell(x, y, Dead())

  def calcNeighbors(cell: Cell): Int = {
    ???
  }

  def xOutOfRange(x: Int): Boolean = x < 0 || x >= width

  def yOutOfRange(y: Int): Boolean = y < 0 || y >= height
}
