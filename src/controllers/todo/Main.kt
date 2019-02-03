package controllers.todo

import domain.entities.Todo
import usecases.interactors.AddTodoInteractor
import domain.gateways.TodoGatewayInterface

class TodoController(
    val todoGateway: TodoGatewayInterface,
    val validateTodo: (todo: Todo) -> Boolean
) {
    val addTodoInteractor = AddTodoInteractor(todoGateway)
    fun addTodo(todo: Todo): String {
        try {
            validateTodo(todo)
            print(todo)
            val result = addTodoInteractor.execute(todo)
            return result
        }
        catch(err: IllegalArgumentException) {
            return err!!.message.toString()
        }
    }
}