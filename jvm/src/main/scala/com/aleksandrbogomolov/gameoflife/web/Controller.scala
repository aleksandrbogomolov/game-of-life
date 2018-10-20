package com.aleksandrbogomolov.gameoflife.web

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

object Controller {

  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("gameoflife-actors")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val routes = {
      pathPrefix("game") {
        concat(
          pathEnd {
            getFromResource("index.html")
          }
        )
      }
    }

    val serverPort = 8080

    Http().bindAndHandle(routes, "localhost", serverPort)
    println(s"Server started on port $serverPort...")
  }
}
