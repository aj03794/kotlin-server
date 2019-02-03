package controllers.todo

import domain.entities.Todo
import usecases.interactors.AddTodoInteractor
import usecases.interactors.DeleteTodoInteractor
import usecases.interactors.GetAllTodosInteractor
import domain.gateways.TodoGatewayInterface

class TodoController(
    val todoGateway: TodoGatewayInterface,
    val validateTodo: (todo: Todo) -> Boolean
) {
    val addTodoInteractor = AddTodoInteractor(todoGateway)
    val deleteTodoInteractor = DeleteTodoInteractor(todoGateway)
    val getAllTodosInteractor = GetAllTodosInteractor(todoGateway)
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
    fun deleteTodo(id: Int): Any {
        var idAsInt: Int
        val todos = getAllTodosInteractor.execute()
        try {
            idAsInt = id.toInt()
            val todo = todos.find{ it.id === id }
            if (todo !is Todo) {
                return "Todo with id: $id does not exist"
            }
            return deleteTodoInteractor.execute(idAsInt)
        }
        catch(err: Throwable) {
            return err!!.message.toString()
        }
    }
}