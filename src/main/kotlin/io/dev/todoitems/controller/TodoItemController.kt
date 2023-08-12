package io.dev.todoitems.controller

import io.dev.todoitems.entity.TodoItem
import io.dev.todoitems.service.TodoItemService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@Controller
class TodoItemPageController(
    private val todoItemService: TodoItemService
) {

    /**
     * 메인 화면
     */
    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("todoItems", todoItemService.findAll())

        return "index"
    }

    /**
     * TO-DO 수정화면
     */
    @GetMapping("/edit/{id}")
    fun editPage(
        @PathVariable id: Long,
        model: Model): String {

        val todoItem = todoItemService
            .findById(id)
            .orElseThrow {
                IllegalStateException("todo item id:$id not found")
            }

        model.addAttribute("todoItem", todoItem)

        return "edit-todo-item"
    }

    /**
     * TO-DO 작성화면
     */
    @GetMapping("/write")
    fun writePage(todoItem: TodoItem): String = "new-todo-item"

}

/**
 * TO-DO 트랜잭션 처리
 */
@Controller
class TodoItemController(
    private val todoItemService: TodoItemService
) {

    private val REDIRECT_TO_MAIN: String = "redirect:/"


    /**
     * TO-DO 작성을 한다.
     */
    @PostMapping("/write")
    fun write(
        request: TodoItem): String {

        val todoItem = TodoItem(
            description = request.description,
            isComplete = request.isComplete,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        todoItemService.write(todoItem)

        return REDIRECT_TO_MAIN
    }

    /**
     * TO-DO를 수정한다.
     */
    @PutMapping("/edit/{id}")
    fun edit(
        @PathVariable("id") id: Long,
        request: TodoItem ): String {
        val todoItem = todoItemService
            .findById(id)
            .orElseThrow {
                IllegalStateException("todo item id:$id not found")
            }

        todoItem.description = request.description
        todoItem.isComplete = request.isComplete

        todoItemService.write(todoItem)

        return REDIRECT_TO_MAIN
    }

    /**
     * TO-DO를 삭제한다.
     */
    @DeleteMapping("/remove/{id}")
    fun remove(@PathVariable("id") id: Long): String {
        val todoItem = todoItemService
            .findById(id)
            .orElseThrow {
                IllegalStateException("todo item id:$id not found")
            }

        todoItemService.remove(todoItem)

        return REDIRECT_TO_MAIN
    }

}