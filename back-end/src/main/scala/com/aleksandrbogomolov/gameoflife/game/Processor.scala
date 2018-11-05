package com.aleksandrbogomolov.gameoflife.game

import com.aleksandrbogomolov.gameoflife.shared.model.{Alive, Cell, Dead, Universe}

object Processor {

  def nextStep(uni: Universe): Universe = {
    val newUni = Universe(uni.width, uni.height)
    for {
      i <- 0 until uni.width
      j <- 0 until uni.height
    } yield {
      val cell = uni.structure(i)(j)
      val neighborsCount = uni.calcNeighbors(cell)

      if (neighborsCount == 3 && cell.isDead) newUni.structure(i)(j) = changeState(cell)
      else if (wrongPopulation(neighborsCount) && cell.isAlive) newUni.structure(i)(j) = changeState(cell)
      else newUni.structure(i)(j) = cell
    }
    newUni
  }

  def wrongPopulation(neighborsCount: Int): Boolean = neighborsCount < 2 || neighborsCount > 3

  def changeState(cell: Cell): Cell = cell.state match {
    case Alive() => cell.copy(state = Dead())
    case Dead() => cell.copy(state = Alive())
  }
}
