package infrastructure.gateways

import domain.gateways.TodoGatewayInterface
import domain.entities.Todo

class TodoGatewayImpl(val todos: ArrayList<Todo> = ArrayList<Todo>()): TodoGatewayInterface {
    override fun delete(id: Int): Todo {
        val todo = this.todos.find{ it.id === id }!!
        this.todos.remove(todo)
        return todo
    }
    override fun add(todo: Todo): String {
        this.todos.add(todo)
        return "todo added"
    }
    override fun get() { println("adding todo to list") }
    override fun getAll(): ArrayList<Todo> {
        return this.todos
    }
}