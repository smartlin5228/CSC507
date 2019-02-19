package com.sample.authentication;

import com.sample.model.Login;
import com.sample.model.Roles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/BookMyRoom")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Grabbing the value of Roles from the submission
        String username = req.getParameter("uname");

        String password = req.getParameter("password");

        // Username and Password Checking
        if ((username == null || username.trim().equals("")) && (password == null || password.trim().equals(""))) {
            String errorMessage = "Please enter username and password.";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } else if (username == null || username.trim().equals("")) {
            String errorMessage = "Please enter username.";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } else if (password == null || password.trim().equals("")) {
            String errorMessage = "Please enter password.";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } else if (Login.authenticateWithDB(username, password) == null) {
            String errorMessage = "Invalid username and password";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } else {

            String role = req.getParameter("Roles");

            Roles r = Roles.valueOf(role);

            if (r.equals(Roles.Employee)){
                req.getRequestDispatcher("employee.jsp").forward(req, res);
            } else if (r.equals(Roles.SystemAdmin)){
                req.getRequestDispatcher("systemadmin.jsp").forward(req, res);
            } else if (r.equals(Roles.Manager)){
                req.getRequestDispatcher("manager.jsp").forward(req, res);
            } else if (r.equals(Roles.Customer)){
                req.getRequestDispatcher("customer.jsp").forward(req, res);
            } else {
                String errorMessage = "Something is wrong.";
                req.setAttribute("error", errorMessage);
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }
        }
    }
}
