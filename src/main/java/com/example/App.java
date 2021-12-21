package com.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        PSQLConnection connection = new PSQLConnection();
        connection.connect();

        System.out.println("Hello World!");

        connection.close();
    }
}
