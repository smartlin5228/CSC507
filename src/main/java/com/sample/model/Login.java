package com.sample.model;

import java.sql.*;

public class Login {
    static Connection mysqlConnection = null;
    static PreparedStatement userStat = null;

    public static void main(String[] argv) {

    }

    public static void makeJDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            log("Login JDBC Driver is Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
        }

        try {
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "csc505", "password");
            if (mysqlConnection != null) {
                log("------------------------Connection Success!----------------------------");
            } else {
                log("------------------------Connection Failed!-----------------------------");
            }
        } catch (SQLException e) {
            log("Mysql Connection Failed!");
            e.printStackTrace();
            return;
        }
    }

    public static void addUserToDB(String username, String password, String role) throws SQLException {
        log("------------------------Local Login-----------------------------");
        makeJDBCConnection();
        String defaultTableName = "userlogin";
        String insertQueryStatement = "insert into userlogin values (?,?,?)";
        userStat = mysqlConnection.prepareStatement(insertQueryStatement);
        userStat.setString(1, username);
        userStat.setString(2, password);
        userStat.setString(3, role);
        userStat.executeUpdate();
        log(username + " Added Successfully!");
        userStat.close();
        mysqlConnection.close();
    }

    public static void getUserFromDB(String username, String password) {
        try {
            makeJDBCConnection();
            String getQueryStatement = "SELECT * FROM userlogin";
            userStat = mysqlConnection.prepareStatement(getQueryStatement);
            ResultSet rs = userStat.executeQuery();
            while (rs.next()) {
                String name = rs.getString("username");
                System.out.format("%s", name);
            }
            userStat.close();
            mysqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Roles authenticateWithDB(String username, String password) {
        try {
            makeJDBCConnection();
            String getQueryStatement = "SELECT role FROM userlogin WHERE username=? AND password=?";
            userStat = mysqlConnection.prepareStatement(getQueryStatement);
            userStat.setString(1, username);
            userStat.setString(2, password);
            ResultSet rs = userStat.executeQuery();

            while (rs.next()) {
                log("User: " + username + " authenticated!");
                String rolename = rs.getString("role");
                userStat.close();
                mysqlConnection.close();
                return Roles.valueOf(rolename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void log(String string) {
        System.out.println(string);
    }
}
