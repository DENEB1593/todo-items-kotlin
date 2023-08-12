package io.dev.todoitems.controller

import io.dev.todoitems.service.TodoItemService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class TodoItemPageControllerTest(
    @Autowired var mockMvc: MockMvc
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

}