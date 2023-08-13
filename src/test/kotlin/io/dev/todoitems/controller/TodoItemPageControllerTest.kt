package io.dev.todoitems.controller

import io.dev.todoitems.service.TodoItemService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class TodoItemPageControllerTest(
    private val mockMvc: MockMvc,
) {

    @MockBean
    lateinit var todoItemService: TodoItemService

    @Test
    fun whenRequestMainPage_ShouldReturn_IndexViewAndTodoitems() {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk)
            .andExpect(view().name("index"))
            .andExpect(model().attributeExists("todoItems"))
    }

    @Test
    fun whenRequestWritePage_ShouldReturn_WriteView() {
        mockMvc.perform(get("/write"))
            .andExpect(status().isOk)
            .andExpect(view().name("new-todo-item"))

    }

}