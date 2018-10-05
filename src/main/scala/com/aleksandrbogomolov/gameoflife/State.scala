package com.aleksandrbogomolov.gameoflife

sealed trait State {}

case class Alive() extends State {

  override def toString: String = "alive"
}

case class Dead() extends State {

  override def toString: String = "dead"
}

case class Empty() extends State {

  override def toString: String = "empty"
}
