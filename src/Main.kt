package com.example

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

import controllers.Controllers
import domain.entities.Todo

fun main(args: Array<String>) {
    val todoController = Controllers().todoController
    embeddedServer(Netty, 9000) {
        install(StatusPages) {
            exception<Throwable> { e ->
                call.respondText(e.localizedMessage,
                    ContentType.Text.Plain, HttpStatusCode.InternalServerError)
            }
        }
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
            }
        }
        install(Routing) {
            post("/todo") {
                val todo = call.receive<Todo>()
                call.respond(todoController.addTodo(todo))
            }
            delete("/todo/id/{id}") {
                call.respond(todoController.deleteTodo(call.parameters["id"]!!.toInt()))
            }
            get("/todo/id/{id}") {
                call.respond(todoController.getTodo(call.parameters["id"]!!.toInt()))
            }
            get("/todos") {
                call.respond(todoController.getAllTodos())
            }
        }
    }.start(wait = true)
}