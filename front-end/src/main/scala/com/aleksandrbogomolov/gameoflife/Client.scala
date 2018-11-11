package com.aleksandrbogomolov.gameoflife

import com.aleksandrbogomolov.gameoflife.shared.JsonSupport
import com.aleksandrbogomolov.gameoflife.shared.model.{Cell, Universe}
import org.scalajs.dom
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.Node
import org.scalajs.dom.{Event, document}
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Client extends JsonSupport {

  def main(args: Array[String]): Unit = {
    dom.window.addEventListener("load", initApplication)
  }

  def initApplication(e: Event): Unit = {
    println("initialising application…")
    getField.onComplete {
      case Success(v) => drawField(v.structure)
      case Failure(ex) => println(s"oops: $ex")
    }
  }

  def getField: Future[Universe] = Ajax.get("http://localhost:3000/game")
    .map(_.responseText)
    .map(Json.parse)
    .map(_.as[Universe])

  def drawField(structure: Array[Array[Cell]]): Unit = {
    val field = document.getElementById("main")
    val table = document.createElement("table")
    table.setAttribute("id", "table")
    val tBody = document.createElement("tbody")
    for {
      array <- structure
    } yield {
      tBody.appendChild(generateTableRow(array))
    }
    table.appendChild(tBody)
    field.appendChild(table)
  }

  def generateTableRow(array: Array[Cell]): Node = {
    val row = document.createElement("tr")
    for (i <- array) {
      val cell = document.createElement("td")
      cell.setAttribute("class", "cell")
      cell.setAttribute("id", i.id)
      cell.appendChild(document.createTextNode(i.toString))
      row.appendChild(cell)
    }
    row
  }
}
