package usecases.interactors

import domain.gateways.TodoGatewayInterface
import domain.entities.Todo

class AddTodoInteractor(val todoGateway: TodoGatewayInterface) {
    fun execute(todo: Todo): String {
        return this.todoGateway.add(todo)
    }
}