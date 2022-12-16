package com.moolight.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moolight.model.Todo;
import com.moolight.model.User;
import com.moolight.repository.TodoRepository;
import com.moolight.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    private final TodoRepository todoRepository;
    private List<Todo> todoList = new CopyOnWriteArrayList<>();

    public RestApiController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public void init() {
        todoList.add(null);
    }

    @GetMapping("/todo")
    public List<Todo> getUsers() {
        return todoList;
    }

    @GetMapping("/todo/{id}")
    public Todo getUser(@PathVariable(name = "id") Long todoId) {
        return todoList.get(todoId.intValue());
    }

    /*
     * @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
     * thành đối tượng Todo
     */
    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name = "todoId") Integer todoId,
            @RequestBody Todo todo) {
        todoList.set(todoId, todo);
        // Trả về đối tượng sau khi đã edit
        return todo;
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable(name = "todoId") Integer todoId) {
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        
        todoList.add(todo);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.ok().body(todo);
    }
}