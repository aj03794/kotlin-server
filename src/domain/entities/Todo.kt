package domain.entities

var myId = 0

data class Todo(val id: Int = myId++ , val name: String = "", val description: String = "", val completed: Boolean = false)

