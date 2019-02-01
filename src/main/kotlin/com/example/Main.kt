package com.example

// fun main(args: Array<String>) = println("\n\nHello Kotlin world from Kobalt\n\n")

// import io.ktor.application.call
// import io.ktor.application.install
// import io.ktor.features.ContentNegotiation
// import io.ktor.gson.gson
// import io.ktor.http.ContentType
// import io.ktor.request.receive
// import io.ktor.response.respond
// import io.ktor.response.respondText
// import io.ktor.routing.*
// import io.ktor.server.engine.embeddedServer
// import io.ktor.server.netty.Netty

//import other.baz

data class Author(val name: String, val website: String)
data class ToDo(var id: Int, val name: String, val description: String, val completed: Boolean)
val toDoList = ArrayList<ToDo>()

fun main(args: Array<String>) {
    println("Hello world")
//    baz()

//    embeddedServer(Netty, 9000) {
//        install(ContentNegotiation) {
//            gson {
//                setPrettyPrinting()
//            }
//        }
//        routing() {
//            route("/todo") {
//                post {
//                    var toDo = call.receive<ToDo>()
//                    toDo.id = getToDoList.size
//                    getToDoList.add(toDo)
//                    call.respond("Added")
//
//                }
//                delete("/{id}") {
////                    call.respond(getToDoList.removeAt(call.parameters["id"]!!.toInt()));
//                    call.respond("1")
//                }
//                get("/{id}") {
//
//                    call.respond(getToDoList[call.parameters["id"]!!.toInt()])
//                }
//                get {
//                    call.respond(getToDoList)
//                }
//            }
//            get("/author"){
//                call.respond(Author("Baeldung","baeldung.com"))
//
//            }
//
//
//        }
//
//    }.start(wait = true)
}