package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    long id;
    String username;
    String email;
    String pass;
    Boolean enabled;

    public Person(long id, String username, String email, String pass, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.enabled = enabled;
    }

    public void create(main.java.org.example.DatabaseConnector dbc) {
        String insert = "Insert into person values ('" +
                this.username + "', '" +
                this.email + "', '" +
                this.pass + "', " +
                this.enabled.toString() + ", " +
                this.id + ")";
        dbc.executeInsert(insert);
    }

    public void read(main.java.org.example.DatabaseConnector dbc) throws SQLException {
        String sql = "SELECT * FROM person WHERE username = '" + this.username + "'";
        ResultSet rs = dbc.executeSelect(sql);
        while (rs.next()) {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String pass = rs.getString("password");
            boolean enabled = rs.getBoolean("enabled");
            Person p = new Person(id, username, email, pass, enabled);
            // przetwarzanie obiektu Person
            System.out.println("id: " + id + ", username: " + username + ", email: " + email + ", pass: " + pass + ", enabled: " + enabled);
        }
    }

    public void update(main.java.org.example.DatabaseConnector dbc) {
        //String sql = "UPDATE person SET username = " + this.username, email = ?, password = ?, enabled = ? WHERE id = ?";
        String sql = "UPDATE person SET email = '" + this.email + "' WHERE username = '" + this.username + "'";
        int count = dbc.executeUpdate(sql);
        System.out.println("Zmodyfikowano " + count + " rekordów.");
    }

    public void delete(main.java.org.example.DatabaseConnector dbc) {
        String sql = "DELETE FROM person WHERE username = '" + this.username + "'";
        int count = dbc.executeDelete(sql);
        System.out.println("Usunięto " + count + " rekordów.");
    }

    public static void addJoke(main.java.org.example.DatabaseConnector dbc, String joke, String username) {
        joke = joke.replace("'", "");
        String insert = "Insert into jokes values ('" +
                joke + "', '" +
                username + "')";
        dbc.executeInsert(insert);
    }

    public static String getJoke(main.java.org.example.DatabaseConnector dbc, String username) throws SQLException {
        String sql = "SELECT * FROM jokes WHERE username = '" + username + "'";
        ResultSet rs = dbc.executeSelect(sql);
        String joke = "";
        while (rs.next()) {
            joke = rs.getString("joke");
            // przetwarzanie obiektu Person
            //System.out.println("joke: " + joke + ", username: " + username);
        }
        return joke;
    }

    public static void updateJoke(main.java.org.example.DatabaseConnector dbc, String joke, String username) {
        String update = "UPDATE jokes SET joke = '" + joke + "' WHERE username = '" + username + "'";
        int count = dbc.executeUpdate(update);
        System.out.println("Zmodyfikowano " + count + " rekordów.");
    }

    public static void deleteJoke(main.java.org.example.DatabaseConnector dbc, String username) {
        String delete = "DELETE FROM jokes WHERE username = '" + username + "'";
        int count = dbc.executeDelete(delete);
        System.out.println("Usunięto " + count + " rekordów.");
    }
}
