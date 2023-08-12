package io.dev.todoitems.service

import io.dev.todoitems.entity.TodoItem
import io.dev.todoitems.repository.TodoItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Transactional
@Service
class TodoItemService(private val todoItemRepository: TodoItemRepository) {

    @Transactional(readOnly = true)
    fun findAll(): List<TodoItem> {
        return todoItemRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Optional<TodoItem> {
        return todoItemRepository.findById(id)
    }

    fun write(todoItem: TodoItem): TodoItem {
        return todoItemRepository.save(todoItem)
    }

    fun remove(todoItem: TodoItem) {
        todoItemRepository.delete(todoItem)
    }

}