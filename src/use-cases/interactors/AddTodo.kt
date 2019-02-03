package usecases.interactors

import domain.gateways.TodoGatewayInterface

class AddTodoInteractor(val todoGateway: TodoGatewayInterface) {
    fun execute(): String {
        return this.todoGateway.add()
    }
}