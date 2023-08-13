package io.dev.todoitems.runner

import com.github.javafaker.Faker
import io.dev.todoitems.entity.TodoItem
import io.dev.todoitems.repository.TodoItemRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
    private val todoItemRepository: TodoItemRepository
): CommandLineRunner {

    val faker = Faker();

    override fun run(vararg args: String?) {

        val todoItems = mutableListOf<TodoItem>()

        for (i in 1..10) {
            val todoItem = TodoItem(
                faker.job().title(),
                faker.bool().bool()
            )
            todoItems.add(todoItem)
        }

        todoItemRepository.saveAll(todoItems)

    }

}