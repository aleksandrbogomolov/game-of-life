package com.aleksandrbogomolov.gameoflife.shared.model

sealed trait State {}

case class Alive() extends State {

  override def toString: String = "X"
}

case class Dead() extends State {

  override def toString: String = " "
}
