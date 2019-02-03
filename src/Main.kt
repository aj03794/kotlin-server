package com.example

// import io.ktor.application.*
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
        }
    }.start(wait = true)
}






        // routing {
        //     post("/todo") {
        //         data class Request()
        //         println("${call::class.simpleName}")
        //         val obj: T = call.receive<T>()
        //         // val response = todoController()
        //         // call.respond(response)
        //         call.respond("hello world")
        //     }
        //     get("/author") {
        //         call.respond("hello from /author")
        //     }
        // }