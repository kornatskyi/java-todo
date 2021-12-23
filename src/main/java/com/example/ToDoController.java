package com.example;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public ToDo createToDo(CorsRegistry registry, @RequestBody JsonNode requestBody) {

        JsonNode body = requestBody.get("body");

        ToDo todo = new ToDo(body.get("text").toString());

        registry.addMapping("/**").allowedOrigins("*");

        System.out.println(todo.getText());

        ToDoManager toDoManager = new ToDoManager();
        toDoManager.createToDo(todo);
        return todo;
    }

    @DeleteMapping("/todo/{text}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public String deleteToDo(CorsRegistry registry, @PathVariable(value = "text") String text) {

        registry.addMapping("/**").allowedOrigins("*");

        System.out.println(text);

        ToDoManager toDoManager = new ToDoManager();
        toDoManager.deleteToDo(text);
        return "Delete to do with text = " + text;
    }

}
