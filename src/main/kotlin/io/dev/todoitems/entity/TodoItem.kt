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
class TodoItem(
    description: String = "",
    isComplete: Boolean = false,
    createdAt: LocalDateTime
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    var id: Long? = null

    @Column(name = "description", nullable = false)
    var description: String = description
        protected set

    @Column(name = "is_complete", nullable = false)
    var isComplete: Boolean = isComplete
        protected set

    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = createdAt
        protected set

    @Column(name = "updatedAt")
    var updatedAt: LocalDateTime? = null
        protected set

    fun update(description: String, isComplete: Boolean) {
        this.description = description
        this.isComplete = isComplete
        this.updatedAt = LocalDateTime.now()
    }
}