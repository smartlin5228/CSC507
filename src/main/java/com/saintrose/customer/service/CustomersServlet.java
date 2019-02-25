package com.saintrose.customer.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.model.CustomerProfile;
import com.sample.model.Login;
import com.sample.model.ServiceRequest;

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
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    	;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response,CustomerProfile profile) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setRequestParams(request,profile);
		request.getRequestDispatcher("customer.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerProfile profile=new CustomerProfile();
		
		 String targetAction = request.getParameter("action");
		 String roomSelected=request.getParameter("roomnosel");
		 
		 request.setAttribute("fromdate",request.getParameter("fromdate"));
		 request.setAttribute("todate",request.getParameter("todate"));
		 
		 String fromDate=request.getParameter("fromdatehid");
		 String toDate=request.getParameter("todatehid");
		
		 setRequestParams(request, profile);
		 if(!"bookroom".equalsIgnoreCase(targetAction) && !"bookroomfinal".equalsIgnoreCase(targetAction)) {
			 if("sr".equalsIgnoreCase(targetAction)) {
				 String name = request.getParameter("roomservice");
				 String servicetime = request.getParameter("servicetime");
				 String roomnumber = request.getParameter("roomnumber");
				 String yname = request.getParameter("yname");
				 ServiceRequest sr = new ServiceRequest();
				 sr.setroomservice(name);
				 sr.setservicetime(servicetime);
				 sr.setroomnumber(roomnumber);
				 sr.setyname(yname);
				 try {
					Login.addServiceRequestToDB(sr);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 } else {
				try {
					Login.addCustomerProfileToDB(profile);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			 }
				
				
				
		 }else if("bookroomfinal".equalsIgnoreCase(targetAction)) {
			 
			 try {
				Login.bookHotelRoomForCustomer(roomSelected,fromDate,toDate,profile.getSsn());
				request.getSession().setAttribute("bookroomflaag",true);
				request.getSession().setAttribute("roomSelected",roomSelected);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }else {
			 bookMyRoom(request, response);
		 }
		 
		 
		 doGet(request, response,profile);
	
	}

	private void setRequestParams(HttpServletRequest request, CustomerProfile profile) {
		profile.setFirstname(request.getParameter("firstname"));
		profile.setMiddlename(request.getParameter("middlename"));
		profile.setLastname(request.getParameter("lastname"));
		profile.setEmail(request.getParameter("email"));
		profile.setAddress(request.getParameter("address"));
		profile.setDob(request.getParameter("dob"));
		profile.setSsn(request.getParameter("ssn"));
		
		request.setAttribute("firstname",profile.getFirstname());
		request.setAttribute("middlename",profile.getMiddlename());
		request.setAttribute("lastname",profile.getLastname());
		request.setAttribute("email",profile.getEmail());
		request.setAttribute("address",profile.getAddress());
		request.setAttribute("dob",profile.getDob());
		request.setAttribute("ssn",profile.getSsn());

		
		request.setAttribute("type", request.getParameter("type"));
		request.setAttribute("guests", request.getParameter("guests"));
		request.setAttribute("rooms", request.getParameter("rooms"));

		
	}
	
	protected void bookMyRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("displaydec", "display");
		request.setAttribute("fromdate",request.getParameter("fromdate"));
		request.setAttribute("todate",request.getParameter("todate"));
	    
	}
}
