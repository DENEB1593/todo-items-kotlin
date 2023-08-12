package io.dev.todoitems.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime


@Entity
@Table(name = "todo_item")
data class TodoItem (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    var description: String,

    @Column(nullable = false)
    var isComplete: Boolean,

    var createdAt: LocalDateTime?,

    var updatedAt: LocalDateTime?

)

fun newTodoItem(description: String, isComplete: Boolean): TodoItem {
    return TodoItem(
        null,
        description,
        isComplete,
        LocalDateTime.now(),
        LocalDateTime.now()
    )
}
