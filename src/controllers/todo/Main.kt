package controllers.todo

import domain.entities.Todo
import usecases.interactors.AddTodoInteractor
import domain.gateways.TodoGatewayInterface

class TodoController(
    val todoGateway: TodoGatewayInterface,
    val validateTodo: () -> Unit
) {
    val addTodoInteractor = AddTodoInteractor(todoGateway)
    fun addTodo(todo: Todo): String {
        validateTodo()
        val result = addTodoInteractor.execute()
        return result
    }
}