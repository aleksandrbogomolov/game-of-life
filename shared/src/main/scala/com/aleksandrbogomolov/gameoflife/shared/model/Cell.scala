package com.aleksandrbogomolov.gameoflife.shared.model

case class Cell(x: Int, y: Int, state: State) {

  def isAlive: Boolean = state.isInstanceOf[Alive]

  def isDead: Boolean = state.isInstanceOf[Dead]

  override def toString: String = state.toString
}
