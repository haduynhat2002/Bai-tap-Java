package com.example.demo.uniti;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/students";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    public static Connection connection;
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                System.out.println("Connection success");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
