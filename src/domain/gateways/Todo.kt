package domain.gateways

import domain.entities.Todo

interface TodoGatewayInterface {
    fun delete() {}
    fun add(todo: Todo): String
    fun get() {}
    fun getAll() {}
}