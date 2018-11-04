package com.aleksandrbogomolov.gameoflife

import com.aleksandrbogomolov.gameoflife.shared.{JsonSupport, Series}
import org.scalajs.dom
import org.scalajs.dom.Event
import org.scalajs.dom.ext.Ajax
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
    displayTitle("The Americans")
    displayTitle("Vinyl")
    getData.onComplete {
      case Success(v) => v.foreach(s => displayTitle(s.title))
      case Failure(ex) => println(s"oops: $ex")
    }
  }

  def displayTitle(title: String): Unit = dom.document.getElementById("titles")
    .insertAdjacentHTML("beforeend", s"<li>$title</li>")

  def getData: Future[Seq[Series]] = Ajax.get("http://localhost:3000/api/start")
    .map(_.responseText)
    .map(Json.parse)
    .map(_.as[Seq[Series]])
}
