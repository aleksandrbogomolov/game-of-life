package com.aleksandrbogomolov.gameoflife

import com.aleksandrbogomolov.gameoflife.model.{Alive, Cell, Universe}

object Main extends App {

  val width = 10
  val height = 10

  val universe = Universe(width, height)
  universe.printStructure()

  universe.structure(2)(3) = Cell(2, 3, Alive())
  universe.structure(2)(4) = Cell(2, 4, Alive())

  universe.printStructure()
}
