package com.example.demo.controller

import com.example.demo.todo.Todo
import com.example.demo.todo.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoRestController(val todoRepository: TodoRepository){

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @RequestMapping(path = [("/{todoId}")], method = [(RequestMethod.GET)])
    fun getTodo(@PathVariable("todoId") todoId: Long): Optional<Todo>? {
        return todoRepository.findById(todoId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateTudo(todo: Todo){
        todoRepository.save(todo)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun insertTodo(todo: Todo){
        todoRepository.save(todo)
    }

    @RequestMapping(path = [("/{todoId}")], method = [(RequestMethod.DELETE)])
    fun deleteTodo(@PathVariable("todoId") todoId: Long) {
        todoRepository.deleteById(todoId)
    }
}