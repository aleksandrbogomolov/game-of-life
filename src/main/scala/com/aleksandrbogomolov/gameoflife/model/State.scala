package com.aleksandrbogomolov.gameoflife.model

sealed trait State {}

case class Alive() extends State {

  override def toString: String = "alive"
}

case class Dead() extends State {

  override def toString: String = "dead"
}
