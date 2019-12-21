package com.saintrose.customer.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.model.CustomerProfile;
import com.sample.model.Login;

/**
 * Servlet implementation class CustomersServlet
 */
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("customer.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerProfile profile=new CustomerProfile();
		
		profile.setFirstname(request.getParameter("firstname"));
		profile.setMiddlename(request.getParameter("middlename"));
		profile.setLastname(request.getParameter("lastname"));
		profile.setEmail(request.getParameter("email"));
		profile.setAddress(request.getParameter("address"));
		profile.setDob(request.getParameter("dob"));
		profile.setSsn(request.getParameter("ssn"));
		
		
		try {
			Login.addCustomerProfileToDB(profile);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("firstname",profile.getFirstname());
		request.setAttribute("middlename",profile.getMiddlename());
		request.setAttribute("lastname",profile.getLastname());
		request.setAttribute("email",profile.getEmail());
		request.setAttribute("address",profile.getAddress());
		request.setAttribute("dob",profile.getDob());
		request.setAttribute("ssn",profile.getSsn());
		
		
		doGet(request, response);
	}

}
