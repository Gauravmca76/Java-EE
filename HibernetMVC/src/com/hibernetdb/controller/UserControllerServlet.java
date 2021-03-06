package com.hibernetdb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hibernetdb.dao.UserDao;

public class UserControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
    /*protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
 
        
 
    }*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
    	String userName = request.getParameter("userName");
        String password = request.getParameter("password1");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
 
        HttpSession session = request.getSession();
        try {
            UserDao userDAO = new UserDao();
            userDAO.addUserDetails(userName, password, email, phone, city);
            response.sendRedirect("Success");
        } catch (Exception e) {
 
            e.printStackTrace();
        }
    }
    
}
