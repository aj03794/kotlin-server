package domain.gateways

import domain.entities.Todo

interface TodoGatewayInterface {
    fun delete(id: Int): Todo
    fun add(todo: Todo): String
    fun get()
    fun getAll(): ArrayList<Todo>
}