package usecases.interactors

import domain.gateways.TodoGatewayInterface
import domain.entities.Todo

class DeleteTodoInteractor(val todoGateway: TodoGatewayInterface) {
    fun execute(id: Int): Todo {
        return this.todoGateway.delete(id)
    }
}