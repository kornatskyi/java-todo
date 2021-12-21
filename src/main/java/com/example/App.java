package com.example;

import java.sql.Date;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ToDoManager toDoManager = new ToDoManager();

        ToDo todo = new ToDo("Learn Java", new Date(System.currentTimeMillis()));
        toDoManager.createToDo(todo);

    }
}
