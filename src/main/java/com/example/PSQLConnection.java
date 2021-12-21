package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PSQLConnection {

    private static final String URL = "jdbc:postgresql://localhost/javatest";
    private static final String USER = "todo_user";
    private static final String PASSWORD = "todo123";

    Connection connection;

    Connection connect() {

        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        try {
            this.connection = DriverManager.getConnection(URL, props);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        System.out.println("Connection successful");
        return this.connection;
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

}
