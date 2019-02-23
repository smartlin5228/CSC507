package com.sample.authentication;

import com.sample.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
    //static Connection con = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String id = req.getParameter("id");
        res.setContentType("text/html");
        out.print("Room has been assinged to you:");
        out.print("<table border='1'><tr><th>ID</th><th>Time</th><th>Service</th><th>Assigned To</th><th>Room</th></tr>");
        try {
            Connection con = Login.makeJDBCConnection();
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "csc505", "password");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM service");
            while (rs.next()) {
                out.print("<tr><td>");

                out.print(rs.getTimestamp("2"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("3"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("4"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("5"));
                out.print("</td></tr>");
            }
            log("Success!");
            con.close();
        } catch (SQLException e) {
            log("something went wrong with table creation");
            e.printStackTrace();
        }
        out.print("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}