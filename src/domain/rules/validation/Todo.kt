package domain.rules.validation

import domain.entities.Todo
import kotlin.reflect.full.memberProperties

fun validateTodo(todo: Todo): Boolean {
    println("validating todo $todo")
    for (prop in Todo::class.memberProperties) {
        if (prop.get(todo) === null) {
            throw IllegalArgumentException("${prop.name} can not be null")
        }
        println("${prop.name} = ${prop.get(todo)}")
    }
    return true
}