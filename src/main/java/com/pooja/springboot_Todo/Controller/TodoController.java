package com.pooja.springboot_Todo.Controller;

import com.pooja.springboot_Todo.model.Todo;
import com.pooja.springboot_Todo.repository.TodoRepository;
import com.pooja.springboot_Todo.request.TodoRequest;
import com.pooja.springboot_Todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> getTodo(@PathVariable int userId) {
        return todoService.findAll(userId);
    }

    @PostMapping
    public List<Todo> addTodo(@RequestBody TodoRequest todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping
    public List<Todo> update(@RequestBody TodoRequest todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> delete(@PathVariable int id) {
        return todoService.delete(id);
    }
}