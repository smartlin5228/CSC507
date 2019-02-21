package com.sample.authentication;

import com.sample.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if ((username == null || username.trim().equals("")) && (password == null || password.trim().equals(""))) {
            String errorMessage = "Please enter username and password.";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("newAccount.jsp").forward(req, res);
        } else if (username == null || username.trim().equals("")) {
            String errorMessage = "Please enter username.";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("newAccount.jsp").forward(req, res);
        } else if (password == null || password.trim().equals("")) {
            String errorMessage = "Please enter password.";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("newAccount.jsp").forward(req, res);
        } else {
            try {
                Login.addUserToDB(username, password, role);
            } catch (SQLException e) {
                String errorMessage = e.getMessage();
                req.setAttribute("error", errorMessage);
                req.getRequestDispatcher("newAccount.jsp").forward(req, res);
            }
            req.setAttribute("success", "User successfully created");
            req.setAttribute("url", "Click here to login with your new username and password!");
            req.getRequestDispatcher("newAccount.jsp").forward(req,res);
        }
    }
}
