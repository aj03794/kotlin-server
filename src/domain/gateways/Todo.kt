package domain.gateways

import domain.entities.Todo

interface TodoGatewayInterface {
    fun delete(id: Int): Todo
    fun add(todo: Todo): String
    fun get(id: Int): Todo
    fun getAll(): ArrayList<Todo>
}