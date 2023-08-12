package io.dev.todoitems.runner

import com.github.javafaker.Faker
import io.dev.todoitems.entity.TodoItem
import io.dev.todoitems.repository.TodoItemRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DataLoader(
    private val todoItemRepository: TodoItemRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {

        val faker = Faker();

        for (i in 1..10) {

            val todoItem = TodoItem(
                description = faker.job().title(),
                isComplete = faker.bool().bool(),
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )

            todoItemRepository.save(todoItem)
        }

    }

}