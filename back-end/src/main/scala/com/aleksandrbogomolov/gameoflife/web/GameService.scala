package com.aleksandrbogomolov.gameoflife.web

import akka.http.scaladsl.model.headers.`Access-Control-Allow-Origin`
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.aleksandrbogomolov.gameoflife.shared.{JsonSupport, Series}
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport

trait GameService extends JsonSupport with PlayJsonSupport {

  lazy val gameApi: Route =
    path("api" / "start") {
      respondWithHeaders(`Access-Control-Allow-Origin`.*) {
        get {
          complete(Seq(Series("8219", "Sense8"), Series("9214", "Better Call Saul")))
        }
      }
    }
}
