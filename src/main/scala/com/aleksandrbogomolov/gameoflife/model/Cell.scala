package com.aleksandrbogomolov.gameoflife.model

class Cell(x: Int, y: Int, state: State) {

  override def toString: String = s"x=$x y=$y state=$state"
}

object Cell {

  def apply(x: Int, y: Int, state: State): Cell = new Cell(x, y, state)
}
