package com.example.sqltest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DatabaseConnection {
    private static DatabaseConnection instance;
    private DataSource dataSource;

    DatabaseConnection() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/dbimpots");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public List<Row> getRows() {
        List<Row> rows = new ArrayList<>();
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM impots");
            while (rs.next()) {
                double seuil = rs.getDouble(1);
                double taux = rs.getDouble(2);
                double decote = rs.getDouble(3);
                rows.add(new Row(seuil, taux, decote));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public void close() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}