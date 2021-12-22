package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToDoManager {

    public void createToDo(ToDo todo) {
        Connection connection = new PSQLConnection().getConnection();

        try {
            connection
                    .createStatement().executeUpdate(
                            "INSERT INTO todos (text, done, created_at) VALUES ('" + todo.getText() + "', '"
                                    + todo.isDone()
                                    + "', '"
                                    + todo.getDate()
                                    + "');");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        System.out.println("ToDo is created");

    }

    public ToDo[] getToDos() {
        Connection connection = new PSQLConnection().getConnection();

        ResultSet result;
        ToDo[] todos;
        ArrayList<ToDo> todoList = new ArrayList<ToDo>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM \"todos\" LIMIT 100;");
            // result = stmt.executeQuery("SELECT * FROM \"todos\" LIMIT 100;");
            stmt.setFetchSize(20);
            result = stmt.executeQuery();
            int i = 0;
            System.out.println("Fetch size: " + result.getFetchSize());
            while (result.next()) {
                if (result.getString("text") != null) {
                    todoList.add(new ToDo(result.getString("text"), result.getBoolean("done"),
                            result.getDate("created_at")));
                    i++;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        todos = todoList.toArray(new ToDo[todoList.size()]);
        return todos;

    }

}
