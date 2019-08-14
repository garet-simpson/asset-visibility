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
import javax.servlet.http.HttpSession;

import com.itemtracer.beans.ProjectBean;
import com.itemtracer.beans.UserBean;
import com.itemtracer.dao.ApplicationDao;

@WebServlet("/newProject")
public class NewProjectServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/jsp/newProject.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		int authorUserId = user.getUserId();
		
		// collect all form data
		String projectName = req.getParameter("newProjectName");
		String projectDescription = req.getParameter("newProjectDescription");

		// fill it up in a User bean
		ProjectBean project = new ProjectBean();
		project.setProjectName(projectName);
		project.setProjectDescription(projectDescription);
		project.setAuthorUserId(authorUserId);
		
		String infoMessage = null;
		infoMessage = project.validate();
		if(infoMessage == null) {
		// call DAO layer and save the user object to DB
			ApplicationDao dao = new ApplicationDao();
			Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
			int rows = dao.addProject(project, user, connection);
			
			// prepare an information message for user about the success or failure of the operation
			if(rows==0){
				infoMessage="Sorry, an error occurred!";
			}
			else{
				infoMessage="New project Added";
				ProjectBean newProject = dao.getProjectBean(project.getProjectName(), connection);
				req.setAttribute("newProject", newProject);
			}
		}
		req.setAttribute("newProjectMessage", infoMessage);
		req.getRequestDispatcher("/jsp/newProject.jsp").forward(req, resp);
				
	}


	
}
