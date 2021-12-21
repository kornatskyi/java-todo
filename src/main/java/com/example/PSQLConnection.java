package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PSQLConnection {

    private static final String URL = "jdbc:postgresql://localhost/todo";
    private static final String USER = "todo_user";
    private static final String PASSWORD = "todo123";

    Connection connection;

    PSQLConnection() {
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            this.connection = DriverManager.getConnection(URL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void close() {

        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection close failed");

        }
        System.out.println("Connection closed");
    }

    void query(String query) {

        // Database response
        int statement;

        try {
            statement = this.connection.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed");
            return;
        }

        System.out.println(statement + " rows affected");
        System.out.println("Query successful");
    }

}
