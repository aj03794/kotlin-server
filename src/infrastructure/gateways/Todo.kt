package infrastructure.gateways

import domain.gateways.TodoGatewayInterface
import domain.entities.Todo

class TodoGatewayImpl(val todos: ArrayList<Todo> = ArrayList<Todo>()): TodoGatewayInterface {
    override fun delete() { println("adding todo to list") }
    override fun add(todo: Todo): String {
        this.todos.add(todo)
        println(this.todos)
        return "todo added"
    }
    override fun get() { println("adding todo to list") }
    override fun getAll() { println("adding todo to list") }
}