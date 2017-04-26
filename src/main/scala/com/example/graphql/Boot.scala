package com.example.graphql

import akka.http.scaladsl.Http

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.example.graphql.rest.UserRoute

object Boot extends App {
  implicit val system = ActorSystem("graphql-server")
  implicit val materializer = ActorMaterializer()
  Http().bindAndHandle(new UserRoute().route, "0.0.0.0", 48080)
}
