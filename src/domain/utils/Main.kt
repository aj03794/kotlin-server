package domain.utils

import domain.entities.Todo


fun todoExists(todos: ArrayList<Todo>, id: Int): Boolean {
    val todo = todos.find{ it.id === id }
    if (todo !is Todo) return false
    return true
}