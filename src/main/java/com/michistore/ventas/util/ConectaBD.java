package com.michistore.ventas.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {

    private static ConectaBD instance = null;
    private final String URL = "jdbc:mysql://localhost:3306/ventas";
    private final String USER = "root";
    private final String PASS = "admin";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private ConectaBD() {}

    public static ConectaBD getInstance() {
        if (instance == null) {
            instance = new ConectaBD();
        }
        return instance;
    }

    public Connection getConexion() throws SQLException{
        Connection connection = null;
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException | SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return connection;
    }

}
