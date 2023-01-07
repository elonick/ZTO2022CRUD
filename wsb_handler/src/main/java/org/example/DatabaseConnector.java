package main.java.org.example;

import java.sql.*;

public class DatabaseConnector {
    public static final String HOST = "jdbc:postgresql://snuffleupagus.db.elephantsql.com/";
    public static final String DATABASE = "fxuvdggl";
    public static final String USERNAME = "fxuvdggl";
    public static final String PASS = "XywMS_EahUtQ_FA5IjNJas6OUbO6XNHE";

    public Connection connection;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(HOST + DATABASE, USERNAME, PASS);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        System.out.println("Opened Database succesfully");
    }
        // CRUD


    // Create
    public void executeInsert(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            stm.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public ResultSet executeSelect(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Update
    public int executeUpdate(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public int executeDelete(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}