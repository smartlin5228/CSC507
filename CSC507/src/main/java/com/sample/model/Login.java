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
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csc505", "root", "Balu@2121");
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
        
        String id="1";
        makeJDBCConnection();
        String defaultTableName = "userlogin";
        String insertQueryStatement = "insert into userlogin values (?,?,?,?)";
        userStat = mysqlConnection.prepareStatement(insertQueryStatement);
        userStat.setString(1,id);
        userStat.setString(2, username);
        userStat.setString(3, password);
        userStat.setString(4, role);
        userStat.executeUpdate();
        log(username + " Added Successfully!");
        userStat.close();
        mysqlConnection.close();
    }
    public static void addCustomerProfileToDB(CustomerProfile profile) throws SQLException {
        log("------------------------Local Login-----------------------------");
        
        String insertQueryStatement;
        int r=getCustomerFromDB(profile.getSsn());
        
        if(r==0) {
        	 insertQueryStatement = "insert into Customer_Profile values (?,?,?,?,?,?,?,?)";
        }else {
        	
        		insertQueryStatement="update Customer_Profile set fullname=? , DOB=? , email=? , address=? where ssn=? ";
        }
        int temid=getMaxIdFromCustomerDB()+1;
        String id=Integer.toString(temid);
        makeJDBCConnection();
        String defaultTableName = "userlogin";
        
        
        String fullName= profile.getFirstname().concat(" ").concat(profile.getMiddlename()).concat(" ").concat(profile.getLastname());
        
        userStat = mysqlConnection.prepareStatement(insertQueryStatement);
        
       
        if(r==0) {
        	 userStat.setString(1,id);
             userStat.setString(2,fullName);
             userStat.setString(3, profile.getDob());
             userStat.setString(4, profile.getEmail());
             userStat.setString(5, profile.getSsn());
             userStat.setString(6, profile.getAddress());
        	userStat.setString(7,"0");
            userStat.setString(8,"0");
        }else {
        	
        	
             userStat.setString(1,fullName);
             userStat.setString(2, profile.getDob());
             userStat.setString(3, profile.getEmail());
             userStat.setString(4, profile.getAddress());
             userStat.setString(5, profile.getSsn());
        }
       
        userStat.executeUpdate();
        log(fullName + " Added Successfully!");
        userStat.close();
        mysqlConnection.close();
    }
    
    public static int getCustomerFromDB(String ssn) {
    	int res=0;
        try {
            makeJDBCConnection();
            String getQueryStatement = "SELECT * FROM Customer_Profile where ssn in(?)";
            userStat = mysqlConnection.prepareStatement(getQueryStatement);
            userStat.setString(1,ssn);
            ResultSet rs = userStat.executeQuery();
            while (rs.next()) {
                res= Integer.parseInt(rs.getString("id"));
               
            }
            userStat.close();
            mysqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return res;
    }
    
    
    public static int getMaxIdFromCustomerDB() {
    	int res=0;
        try {
            makeJDBCConnection();
            String getQueryStatement = "SELECT max(id) max_id from Customer_Profile";
            userStat = mysqlConnection.prepareStatement(getQueryStatement);
            ResultSet rs = userStat.executeQuery();
            while (rs.next()) {
                res= rs.getInt("max_id");
               
            }
            userStat.close();
            mysqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return res;
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
