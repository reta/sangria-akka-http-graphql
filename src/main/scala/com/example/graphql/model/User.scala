package com.example.graphql.model

import java.util.Locale
import java.time.LocalDateTime

object Role extends Enumeration {
  val USER, ADMIN = Value
}

case class Address(street: String, city: String, state: String, zip: String, country: String)

case class User(id: Long, email: String, created: Option[LocalDateTime], firstName: Option[String], lastName: Option[String],
  roles: Option[Seq[Role.Value]], active: Option[Boolean], address: Option[Address])
