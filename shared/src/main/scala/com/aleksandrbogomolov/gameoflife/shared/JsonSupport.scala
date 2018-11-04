package com.aleksandrbogomolov.gameoflife.shared

import play.api.libs.json.{Json, OFormat}

trait JsonSupport {

  implicit val SeriesFormat: OFormat[Series] = Json.format[Series]
}
