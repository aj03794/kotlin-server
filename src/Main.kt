package com.example

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

import other.baz

import domain.entities.Author
import domain.entities.Todo

fun main(args: Array<String>) {

    val myAuthor = Author("some", "author")
    val myTodo = Todo(1, "some name", "some description", false)

    println(myAuthor)
    println(myTodo)

    // baz()

    // embeddedServer(Netty, 9000) {
    //     install(ContentNegotiation) {
    //         gson {
    //             setPrettyPrinting()
    //         }
    //     }
    //     routing() {
    //         route("/todo") {
    //             post {
    //                 call.respond("Added")
    //             }
    //         }
    //         get("/author"){
    //             call.respond(Author("Baeldung","baeldung.com"))
    //         }
    //     }
    // }.start(wait = true)
}