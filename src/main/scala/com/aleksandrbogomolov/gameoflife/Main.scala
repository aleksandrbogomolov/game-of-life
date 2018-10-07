package com.aleksandrbogomolov.gameoflife

import com.aleksandrbogomolov.gameoflife.model.{Alive, Cell, Universe}

object Main extends App {

  val width = 10
  val height = 10

  val uni = Universe(width, height)

  for (x <- 0 until width;
       y <- 0 until height) yield uni.structure(x)(y) = Cell(x, y, Alive())

  uni.printStructure()
}
