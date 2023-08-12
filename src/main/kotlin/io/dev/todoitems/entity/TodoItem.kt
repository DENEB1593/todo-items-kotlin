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

    var description: String? = null,

    @Column(nullable = false)
    var isComplete: Boolean? = null,

    var createdAt: LocalDateTime? = null,

    var updatedAt: LocalDateTime? = null

)