package com.itemtracer.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itemtracer.beans.UserBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.dao.ApplicationDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String projectName = "Demo";
		
		//get the username from the login form
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//call DAO for validation logic
		ApplicationDao dao= new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		UserBean user = dao.validateUser(username, password, connection);
		
		//check if user is invalid and set up an error message
		if(user!=null){
			//set up the HTTP session
			

			ProjectBean project = dao.getProjectBean(projectName,connection);
			
			
			
			HttpSession session = req.getSession();
			
			//set the username as an attribute
			session.setAttribute("user", user);
			session.setAttribute("project", project);
			
			//forward to home jsp
			req.getRequestDispatcher("/jsp/dashboard.jsp").forward(req, resp);
		}
		else{
			String errorMessage="Invalid Credentials, please login again!";
			req.setAttribute("loginError", errorMessage);
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
			
			
		}
		
			
		
	}

}
