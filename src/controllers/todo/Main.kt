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
    fun deleteTodo(id: String): String {
        var idAsInt: Int
        try {
            idAsInt = id.toInt()
        }
        catch(err: Throwable) {
            return err!!.message.toString()
        }
        return "Deleted $idAsInt"
    }
}