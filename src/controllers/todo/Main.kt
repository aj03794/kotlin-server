package controllers.todo

import domain.entities.Todo
import usecases.interactors.*
import domain.gateways.TodoGatewayInterface

class TodoController(
    val todoGateway: TodoGatewayInterface,
    val validateTodo: (todo: Todo) -> Boolean,
    val todoExists: (todos: ArrayList<Todo>, id: Int) -> Boolean
) {
    val addTodoInteractor = AddTodoInteractor(todoGateway)
    val deleteTodoInteractor = DeleteTodoInteractor(todoGateway)
    val getAllTodosInteractor = GetAllTodosInteractor(todoGateway)
    val getTodoInteractor = GetTodoInteractor(todoGateway)
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
        return if (!this.internalTodoExists(id)) "Todo with id: $id does not exist"
        else deleteTodoInteractor.execute(id)
    }
    fun getTodo(id: Int): Any {
        return if (!this.internalTodoExists(id)) "Todo with id: $id does not exist"
        else getTodoInteractor.execute(id)
    }
    fun getAllTodos(): ArrayList<Todo> {
        return getAllTodosInteractor.execute()
    }
    private fun internalTodoExists(id: Int): Boolean {
        return todoExists(getAllTodosInteractor.execute(), id)
    }
}

