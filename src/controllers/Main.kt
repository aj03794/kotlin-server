package controllers

import domain.entities.Todo
import usecases.interactors.AddTodoInteractor
import controllers.todo.TodoController
import infrastructure.gateways.TodoGatewayImpl
import domain.gateways.TodoGatewayInterface
import domain.rules.validation.validateTodo

class Controllers(
    val todoGateway: TodoGatewayInterface = TodoGatewayImpl()) {
    val todoController = TodoController(todoGateway, ::validateTodo)
}