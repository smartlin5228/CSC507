package com.sample.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login {
    static Connection mysqlConnection = null;
    static PreparedStatement userStat = null;
    private static SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
    private static SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");


    public static void main(String[] argv) {

    }
    
    public static String formatDate(String inDate) {
        String outDate = "";
        if (inDate != null) {
            try {
                Date date = inSDF.parse(inDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex){ 
            }
        }
        return outDate;
      }


    public static Connection makeJDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            log("Login JDBC Driver is Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
        }

        try {
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health", "vipul", "vipul");
            if (mysqlConnection != null) {
                log("------------------------Connection Success!----------------------------");
                return mysqlConnection;
            } else {
                log("------------------------Connection Failed!-----------------------------");
                return null;
            }
        } catch (SQLException e) {
            log("Mysql Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeJDBCConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            log("Connection is not closed.");
            e.printStackTrace();
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
        log("------------------------Adding customer profile to DB-----------------------------");
        
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

	public static  void bookHotelRoomForCustomer(String roomSelected, String fromDate, String toDate,String ssn) throws SQLException {
		 String insertQueryStatement;
		 fromDate= formatDate(fromDate);
		 toDate= formatDate(toDate);
		  log("------------------------Booking Hotel Room For Customer-----------------------------");
		int customerId=getCustomerFromDB(ssn);
		String id=Integer.toString(customerId);
		 makeJDBCConnection();
		insertQueryStatement="update ROOM_DETAIL set BOOKED_FROM=? , BOOKED_TO=? , CUSTOMER_ID=? , AVAILABLE_STATUS=0 where ROOM_NUM=? ";
		userStat = mysqlConnection.prepareStatement(insertQueryStatement);
		
		 userStat.setString(1,fromDate);
         userStat.setString(2,toDate);
         userStat.setString(3,id);
         userStat.setString(4,roomSelected);
         
         userStat.executeUpdate();
         log("Hotel Room" +roomSelected+" booked by customer id "+id);
         
         log("------------------------Updating payment status-----------------------------");
         updateCustomerPaymentStatus(id);
         userStat.close();
         mysqlConnection.close();
	}
	
	 public static void updateCustomerPaymentStatus(String customerid) throws SQLException {
	      
		 String insertQueryStatement;
	        	
	     insertQueryStatement="update Customer_Profile set payment_status=1 where id=? ";
	        
	        userStat = mysqlConnection.prepareStatement(insertQueryStatement);
	        userStat.setString(1,customerid);
	        userStat.executeUpdate();
	      
	    }
}
