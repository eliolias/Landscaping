package com.solvd.landscapingApp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;


public class ConnectionPool {

    private static ConnectionPool pool;
    private static final List<Connection> connectionPool = new ArrayList<>(5);

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
            for (int i = 0; i < 5; i++) {
                try {
                    connectionPool.add(DriverManager.getConnection("jdbc:mysql://localhost:3306/landscaping", "root", "Ex2l1jkv!"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return pool;
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("no available connections");
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        return connection;
    }

}
