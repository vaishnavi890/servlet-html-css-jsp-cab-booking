package com.vaishnavi.cab.booking.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cabdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        int attempts = 0;
        do {
            try {
                conn = DriverManager.getConnection(URL, USER, PASS);
                break;
            } catch (SQLException e) {
                attempts++;
                System.out.println("Connection attempt " + attempts + " failed.");
            }
        } while (attempts < 3);
        return conn;
    }
}
