package io.dev.todoitems.entity

import jakarta.persistence.*

@Entity
@Table(name = "todo_item")
class TodoItem(
    description: String? = "",
    isComplete: Boolean? = false
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    var id: Long? = null
        protected set

    @Column(name = "description", nullable = false)
    var description: String? = description
        protected set

    @Column(name = "is_complete", nullable = false)
    var isComplete: Boolean? = isComplete
        protected set

    fun update(description: String? = "", isComplete: Boolean? = false) {
        this.description = description
        this.isComplete = isComplete
    }
}