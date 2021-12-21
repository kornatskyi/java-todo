package com.example;

public class ToDoManager {

    public void createToDo(ToDo todo) {

        PSQLConnection connection = new PSQLConnection();

        connection
                .query("INSERT INTO todos (text, done, created_at) VALUES ('" + todo.getText() + "', '" + todo.isDone()
                        + "', '"
                        + todo.getDate()
                        + "');");

    }

}
