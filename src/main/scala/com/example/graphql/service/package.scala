package com.example.graphql

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.example.graphql.model.Role
import java.util.Locale

package object service {
  import reactivemongo.bson._

  implicit object LocalDateTimeReader extends BSONReader[BSONValue, LocalDateTime] {
    def read(bson: BSONValue): LocalDateTime = LocalDateTime.parse(bson.asInstanceOf[BSONString].value)
  }
  
  implicit object LocalDateTimeWriter extends BSONWriter[LocalDateTime, BSONString] {
    def write(value: LocalDateTime): BSONString = BSONString(value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
  }
  
  implicit object RoleReader extends BSONReader[BSONValue, Role.Value] {
    def read(bson: BSONValue): Role.Value = Role.withName(bson.asInstanceOf[BSONString].value)
  }
  
  implicit object RoleWriter extends BSONWriter[Role.Value, BSONValue] {
    def write(value: Role.Value): BSONString = BSONString(value.toString)
  }
  
  implicit object LocaleReader extends BSONReader[BSONValue, Locale] {
    def read(bson: BSONValue): Locale = Locale.forLanguageTag(bson.asInstanceOf[BSONString].value)
  }
  
  implicit object LocaleWriter extends BSONWriter[Locale, BSONValue] {
    def write(value: Locale): BSONString = BSONString(value.toLanguageTag)
  }
}