package org.example;

import java.sql.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //createDatabase();
        //createTable();

    }

    public static void createDatabase() {
        final String DB_URL = "jdbc:mariadb://localhost/";    //адреса підключення до БД
        final String USER = "root";                           // користувач та пароль
        final String PASSWORD = "";

        Connection connection = null;      //підключення
        Statement statement = null;        // statement для запитів до БД

        try {
            // Step 1: Register JDBC driver (only required in older JDBC versions)
            // Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); //підключаємося до БД

            // Step 3: Create a statement
            statement = connection.createStatement(); //створюємо statement у нашому підключенні

            Scanner in = new Scanner(System.in);     //створюємо сканер
            System.out.println("Вкажіть назву БД:");
            String dbName =in.nextLine();             //присвоюємо назву БД введену в консолі

            // Step 4: Execute SQL query to create a database
            String sql = "CREATE DATABASE "+dbName;   // запит на створення БД
            statement.executeUpdate(sql);             //виконуємо запит
            System.out.println("Database created successfully.");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();      //виводимо помилку при створенні БД
        } finally {
            // Step 5: Close resources
            try {
                if (statement != null) { //закриваємо statement
                    statement.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (connection != null) { //закриваємо підключення
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    public  static void createTable(){
        final String DB_URL = "jdbc:mariadb://localhost/salo"; //адреса підключення до БД
        final String USER = "root";                            //данні користувача
        final String PASSWORD = "";

        Connection connection = null;     //підключення
        Statement statement = null;       // statement для запитів до БД

        try {
            // Step 1: Register JDBC driver (only required in older JDBC versions)
            // Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);  //підключаємося до БД

            // Step 3: Create a statement
            statement = connection.createStatement();   //створюємо statement

            // Step 4: Execute SQL query to create a table
            String sql = "CREATE TABLE user (" +         //запит на створення таблиці
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "username VARCHAR(50) NOT NULL," +
                    "email VARCHAR(100) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")";
            statement.executeUpdate(sql);               //виконуємо запит
            System.out.println("Table 'user' created successfully.");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Step 5: Close resources
            try {
                if (statement != null) {
                    statement.close();   //закриваємо statement
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();  //закриваємо підключення до БД
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}