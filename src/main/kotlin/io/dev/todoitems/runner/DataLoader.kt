package io.dev.todoitems.runner

import com.github.javafaker.Faker
import io.dev.todoitems.entity.newTodoItem
import io.dev.todoitems.repository.TodoItemRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
    private val todoItemRepository: TodoItemRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {

        val faker = Faker();

        for (i in 1..10) {

            val todoItem = newTodoItem(
                faker.job().title(),
                faker.bool().bool()
            )

            todoItemRepository.save(todoItem)
        }

    }

}