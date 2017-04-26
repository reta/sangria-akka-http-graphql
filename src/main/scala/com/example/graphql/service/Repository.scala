package com.example.graphql.service

import scala.concurrent.Future
import com.example.graphql.model.Role
import com.example.graphql.model.User

trait Repository {
  def findById(id: Long): Future[Option[User]];
  def addUser(email: String, firstName: Option[String], lastName: Option[String], roles: Seq[Role.Value]): Future[User]
  def activateById(id: Long): Future[Option[User]]
  def findAll(fields: Seq[String]): Future[Seq[User]]
}
