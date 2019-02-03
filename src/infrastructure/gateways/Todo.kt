package infrastructure.gateways

import domain.gateways.TodoGatewayInterface

class TodoGatewayImpl: TodoGatewayInterface {
    constructor() {
        println("=-=-=-=-=-=-=")
    }
    override fun delete() { println("adding todo to list") }
    override fun add(): String = "Added todo"
    override fun get() { println("adding todo to list") }
    override fun getAll() { println("adding todo to list") }
}