package com.example;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Controller
public class ToDoController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/todos")
    @ResponseBody
    public ToDo[] getTodos(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");

        ToDoManager toDoManager = new ToDoManager();
        ToDo[] todos = toDoManager.getToDos();
        return todos;

    }

    @PostMapping("/todo/add")
    @ResponseBody
    public ToDo createToDo(CorsRegistry registry, @RequestBody ToDo todo) {
        registry.addMapping("/**").allowedOrigins("*");

        System.out.println(todo.getText());

        ToDoManager toDoManager = new ToDoManager();
        toDoManager.createToDo(todo);
        return todo;
    }

}
