package com.itemtracer.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itemtracer.beans.UserBean;
import com.itemtracer.dao.ApplicationDao;

@WebServlet("/viewProfile")
public class ViewProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* MOVED TO SESSION VARIABLE USER
		//get the username from the session
		UserBean user = (String)request.getSession().getAttribute("username");
		
		//call dao and get profile details
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		UserBean user = dao.getProfileDetails(username, connection);
		
		//store all information in request object
		request.setAttribute("user", user);
		*/
		
		//forward control to profile jsp
		
		request.getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
		
	}


}
