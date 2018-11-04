package com.aleksandrbogomolov.gameoflife.web

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.aleksandrbogomolov.gameoflife.shared.{JsonSupport, Series}
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport

trait GameService extends JsonSupport with PlayJsonSupport {

  lazy val gameApi: Route =
    pathPrefix("game") {
      concat(
        pathEndOrSingleSlash {
          concat(
            get {
              complete(Seq(Series("8219", "Sense8"), Series("9214", "Better Call Saul")))
            },
            post {
              // submit start cells
              ???
            }
          )
        },
        path("run") {
          get {
            // run game
            ???
          }
        },
        path("finish") {
          get {
            // get statistic
            ???
          }
        }
      )
    }
}
