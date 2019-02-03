package usecases.interactors

import domain.gateways.TodoGatewayInterface
import domain.entities.Todo

class GetAllTodosInteractor(val todoGateway: TodoGatewayInterface) {
    fun execute(): ArrayList<Todo> {
        return this.todoGateway.getAll()
    }
}