package com.itemtracer.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.itemtracer.beans.UserBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.dao.ApplicationDao;
import com.itemtracer.dao.DBConnection;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	//https://www.codejava.net/servers/tomcat/configuring-jndi-datasource-for-database-connection-pooling-in-tomcat
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

		
		String projectName = "Demo";
		
		//get the username from the login form
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//call DAO for validation logic
		ApplicationDao dao= new ApplicationDao();
		
		
		UserBean user = dao.validateUser(username, password, connection);
		
		//check if user is invalid and set up an error message
		if(user!=null){
			//set up the HTTP session
			

			ProjectBean project = dao.getProjectBean(projectName,connection);
			
			
			
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
