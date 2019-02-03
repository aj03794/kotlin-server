package usecases.interactors

import domain.gateways.TodoGatewayInterface
import domain.entities.Todo

class GetTodoInteractor(val todoGateway: TodoGatewayInterface) {
    fun execute(id: Int): Todo {
        return this.todoGateway.get(id)
    }
}