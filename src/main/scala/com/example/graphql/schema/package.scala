package com.example.graphql

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import scala.Left
import scala.Right
import scala.util.Failure
import scala.util.Success
import scala.util.Try

import sangria.ast.StringValue
import sangria.schema.ScalarType
import sangria.validation.ValueCoercionViolation
import java.util.Locale

package object schema {
  case object LocalDateTimeCoercionViolation extends ValueCoercionViolation("Date value expected")
  case object LocaleCoercionViolation extends ValueCoercionViolation("Locale value expected")

  private[schema] def parseLocalDateTime(s: String) = Try(LocalDateTime.parse(s)) match {
    case Success(date) => Right(date)
    case Failure(_) => Left(LocalDateTimeCoercionViolation)
  }

  val LocalDateTimeType = ScalarType[LocalDateTime]("LocalDateTime",
    coerceOutput = (value, caps) => value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
    coerceUserInput = {
      case s: String => parseLocalDateTime(s)
      case _ => Left(LocalDateTimeCoercionViolation)
    },
    coerceInput = {
      case strVal: StringValue => parseLocalDateTime(strVal.value)
      case _ => Left(LocalDateTimeCoercionViolation)
    })
}
