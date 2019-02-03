package controllers.todo

import domain.entities.Todo
import usecases.interactors.AddTodoInteractor
import usecases.interactors.DeleteTodoInteractor
import domain.gateways.TodoGatewayInterface

class TodoController(
    val todoGateway: TodoGatewayInterface,
    val validateTodo: (todo: Todo) -> Boolean
) {
    val addTodoInteractor = AddTodoInteractor(todoGateway)
    val deleteTodoInteractor = DeleteTodoInteractor(todoGateway)
    fun addTodo(todo: Todo): String {
        try {
            validateTodo(todo)
            val result = addTodoInteractor.execute(todo)
            return result
        }
        catch(err: IllegalArgumentException) {
            return err!!.message.toString()
        }
    }
    fun deleteTodo(id: String): Todo {
        var idAsInt: Int
        try {
            idAsInt = id.toInt()
            return DeleteTodoInteractor.execute(int)
        }
        catch(err: Throwable) {
            return err!!.message.toString()
        }
    }
}