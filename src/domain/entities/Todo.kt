package domain.entities

var myId = 1

data class Todo(val id: Int = myId++ , val name: String = "", val description: String = "", val completed: Boolean = false)

