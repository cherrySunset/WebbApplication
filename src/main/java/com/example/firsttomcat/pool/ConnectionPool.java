package com.example.firsttomcat.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;
    private BlockingQueue<Connection> free = new LinkedBlockingQueue<>(8);
    private BlockingQueue<Connection> used = new LinkedBlockingQueue<>(8);

    static {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            //Class.forName("org.postgresql.Driver");
         } catch (SQLException e) {
           throw new ExceptionInInitializerError(e);
    }
}

private ConnectionPool() {
    String url = "jdbc:postgresql://localhost:5432/phonestest2";
    Properties prop = new Properties();
    prop.put("user", "postgres");
    prop.put("password", "lobanka14");
    prop.put("autoReconnect", "true");
    prop.put("characterEncoding", "UTF-8");
    prop.put("useUnicode", "true");
    prop.put("useSSL", "true");
    prop.put("useJDBCCompliantTimezoneShift", "true");
    prop.put("useLegacyDatetimeCode", "false");
    prop.put("serverTimezone", "UTC");
    prop.put("serverSsICent", "classpath:server.crt");
    for (int i = 0; i < 8; i++) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
        free.add(connection);
    }
}

public static ConnectionPool getInstance() {
    instance = new ConnectionPool();
    return instance;
}

public Connection getConnection() {
    Connection connection = null;
    try {
        connection = free.take();
        used.put(connection);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
    }
    return connection;
}

public void releaseConnection(Connection connection) {
    try {
        used.remove(connection);
        free.put(connection);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public void destroyPool() {
    for (int i = 0; i < 8; i++) {
        try {
            free.take().close();
        } catch (SQLException | InterruptedException e) {

        }
    }
}
}
