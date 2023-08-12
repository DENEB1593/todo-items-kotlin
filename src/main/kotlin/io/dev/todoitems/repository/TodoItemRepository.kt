package io.dev.todoitems.repository

import io.dev.todoitems.entity.TodoItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoItemRepository: JpaRepository<TodoItem, Long>  {
}