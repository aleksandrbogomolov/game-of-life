package com.aleksandrbogomolov.gameoflife.shared.model

case class Cell(x: Int, y: Int, state: State) {

  def isAlive: Boolean = state.isInstanceOf[Alive]

  def isDead: Boolean = state.isInstanceOf[Dead]

  def id: String = s"$x:$y"

  override def toString: String = state.toString
}
