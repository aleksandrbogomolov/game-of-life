package com.aleksandrbogomolov.gameoflife.shared

import com.aleksandrbogomolov.gameoflife.shared.model.Universe
import play.api.libs.json.{Json, OFormat}

trait JsonSupport {

  implicit val UniverseFormat: OFormat[Universe] = Json.format[Universe]
}
