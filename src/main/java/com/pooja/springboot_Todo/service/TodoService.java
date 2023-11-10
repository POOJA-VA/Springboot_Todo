package com.pooja.springboot_Todo.service;

import com.pooja.springboot_Todo.model.AppUser;
import com.pooja.springboot_Todo.model.Todo;
import com.pooja.springboot_Todo.repository.AppUserRepository;
import com.pooja.springboot_Todo.repository.TodoRepository;
import com.pooja.springboot_Todo.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private AppUserRepository appUserRepository;
    public List<Todo> findAll(int userId) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getAppUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> addTodo(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUid()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUid());
    }

    public List<Todo> update(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUid()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUid());
    }

    public List<Todo> delete(Integer id) {
        int userId = todoRepository.findById(id).get().getAppUser().getId();
        todoRepository.deleteById(id);
        return findAll(userId);
    }
}
