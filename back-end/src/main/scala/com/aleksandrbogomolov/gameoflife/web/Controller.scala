package com.aleksandrbogomolov.gameoflife.web

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success}

object Controller extends GameService {

  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("game-of-life-actors")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

//    val routes = {
//      pathPrefix("game") {
//        concat(
//          pathEnd {
//            getFromResource("index.html")
//          }
//        )
//      }
//    }

    val serverPort = 3000

//    Http().bindAndHandle(routes, "localhost", serverPort)
//    println(s"Server started on port $serverPort...")

    Http().bindAndHandle(gameApi, "localhost", serverPort) onComplete {
      case Success(b) => println(s"server is running ${b.localAddress}")
      case Failure(e) => println(s"there was an error starting the server $e")
    }
  }
}
