package com.itemtracer.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itemtracer.beans.ProjectBean;
import com.itemtracer.beans.UserBean;
import com.itemtracer.beans.ProjectUserSummaryBean;
import com.itemtracer.dao.ApplicationDao;

/**
 * Servlet implementation class ChangeProjectServlet
 */
@WebServlet("/changeProject")
public class ChangeProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ProjectBean projectBean = (ProjectBean) session.getAttribute("project");
		String projectName = projectBean.getProjectName();
		UserBean userBean = (UserBean) session.getAttribute("user");
		String userName = userBean.getUserName();
		
		// Get unique list of all part number for User
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		List<String> projectNames = dao.getUserProjects(userName, connection);
		req.setAttribute("projectNames", projectNames);
		
		List<ProjectUserSummaryBean> projectUserSummaryBeans = dao.getProjectUserSummaryBean(projectName, connection);
		req.setAttribute("projectUserSummaryBeans", projectUserSummaryBeans);
		
		req.getRequestDispatcher("/jsp/changeProject.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		UserBean userBean = (UserBean) session.getAttribute("user");
		String userName = userBean.getUserName();
		
		String projectName = (String) req.getParameter("projectName");
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		
		List<String> projectNames = dao.getUserProjects(userName, connection);
		req.setAttribute("projectNames", projectNames);


		List<ProjectUserSummaryBean> projectUserSummaryBeans = dao.getProjectUserSummaryBean(projectName, connection);
		req.setAttribute("projectUserSummaryBeans", projectUserSummaryBeans);
		
		ProjectBean project = dao.getProjectBean(projectName, connection);
		session.setAttribute("project", project);
	

		req.getRequestDispatcher("/jsp/changeProject.jsp").forward(req, resp);
	}

}
