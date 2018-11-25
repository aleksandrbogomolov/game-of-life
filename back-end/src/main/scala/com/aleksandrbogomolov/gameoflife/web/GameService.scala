package com.aleksandrbogomolov.gameoflife.web

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.aleksandrbogomolov.gameoflife.shared.JsonSupport
import com.aleksandrbogomolov.gameoflife.shared.model.Universe
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport

trait GameService extends JsonSupport with PlayJsonSupport {

  lazy val gameApi: Route =
    pathPrefix("game") {
      concat(
        pathEndOrSingleSlash {
          concat(
            get {
              complete(Universe(50, 50))
            },
            post {
              entity(as[Universe]) { universe =>
                universe.printStructure()
                complete(StatusCodes.OK)
              }
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
