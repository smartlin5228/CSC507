package com.sample.authentication;

import com.sample.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String id = req.getParameter("id");
        res.setContentType("text/html");
        out.print("Room has been assigned to you:");
        out.print("<table border='1'><tr><th>ID</th><th>Time</th><th>Service</th><th>Assigned To</th><th>Room</th></tr>");
        try {
            String url="jdbc:mysql://localhost:3306/userlogin";
            String username="csc505";
            String password="password";
            String query="SELECT * FROM service WHERE room=" + id;
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement psmt = conn.prepareStatement("UPDATE service SET owner=? WHERE room=?");
            HttpSession session = req.getSession();
            String un = (String) session.getAttribute("username");
            psmt.setString(1, un);
            psmt.setString(2, id);
            int result = psmt.executeUpdate();

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                out.print("<tr><td>");

                out.print(rs.getInt("id"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("timestamp"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("service_type"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("owner"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("room"));
                out.print("</td></tr>");
            }
            conn.close();
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