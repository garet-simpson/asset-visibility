package com.itemtracer.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itemtracer.beans.UserBean;
import com.itemtracer.dao.ApplicationDao;
import com.itemtracer.dao.DBConnection;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		if(connection == null) {
			connection = DBConnection.getConnectionToDatabase();
			req.getServletContext().setAttribute("dbconnection", connection);
		}
		
		
		// collect all form data
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		Date timeStamp = new Date();
		Integer authorUserId = 1;

		
		
		// fill it up in a User bean
		UserBean user = new UserBean();
		user.setUsername(userName);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setTimeStamp(timeStamp);
		user.setAuthorUserId(authorUserId);
		
		String infoMessage = null;
		infoMessage = user.validate();
		if(infoMessage == null) {
		// call DAO layer and save the user object to DB
			ApplicationDao dao = new ApplicationDao();
			connection = (Connection)getServletContext().getAttribute("dbconnection");
			int rows = dao.registerUser(user, connection);
		
			// prepare an information message for user about the success or failure of the operation
			if(rows==0){
				infoMessage="Sorry, an error occurred!";
			}
			else{
				infoMessage="User registered successfully. Please Login.";
			}
		}
		req.setAttribute("RegisterMessage", infoMessage);
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
				
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
}
