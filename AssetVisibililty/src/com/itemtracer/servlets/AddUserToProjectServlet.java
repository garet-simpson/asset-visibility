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
import com.itemtracer.beans.AuthorityTypeBean;
import com.itemtracer.beans.ProjectUserSummaryBean;
import com.itemtracer.beans.UserBean;
import com.itemtracer.dao.ApplicationDao;

/**
 * Servlet implementation class ChangeProjectServlet
 */
@WebServlet("/addUserToProject")
public class AddUserToProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		HttpSession session = req.getSession();
		UserBean userBean = (UserBean) session.getAttribute("user");
		String userName = userBean.getUserName();
		
		// Get unique list of all part number
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

		
		List<String> userNames = dao.getUserNamesNonAdmin(userName, connection);
		req.setAttribute("userNames", userNames);
			
		req.getRequestDispatcher("/jsp/addUserToProject.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String submitted = req.getParameter("submit");
		String addUserName = (String) req.getParameter("addUserName");
		
		HttpSession session = req.getSession();
		UserBean userBean = (UserBean) session.getAttribute("user");
		String userName = userBean.getUserName();
		ProjectBean projectBean = (ProjectBean) session.getAttribute("project");
		String projectName = projectBean.getProjectName();
		
		String infoMessage = null;
		int rows = 0;
		
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		UserBean addUserBean = dao.getUserBean( addUserName, connection);
		String requestedAddUserProjectAuthority = (String) req.getParameter("addUserProjectAuthority");
		
		
		// Get unique list of all part number
		
		List<String> userNames = dao.getUserNamesNonAdmin(userName, connection);
		req.setAttribute("userNames", userNames);
		req.setAttribute("addUserName", addUserName);
		
		String userProjectAuthority = dao.getUserProjectAuthority(projectName, userName, connection);
		String currentAddUserProjectAuthority = dao.getUserProjectAuthority(projectName, addUserName, connection);
		
		//prevent updates when user is not an admin
		if(userProjectAuthority.equals("admin")) {
			
			//Get list of valid authority types
			List<String> authorityTypes = dao.getAuthorityTypes(connection);
			req.setAttribute("authorityTypes", authorityTypes);
		
			
			//Add project valid authority types to dropdown box.
			if(submitted==null) {
				req.setAttribute("projectUserSummaryBean", null);
				//if user is currently in database set attribute with authority type
				if (currentAddUserProjectAuthority!=null) {
					infoMessage = addUserName + " has current authority: " + currentAddUserProjectAuthority + "<br/>" + "Select new authority:";
					req.setAttribute("addUserProjectAuthority", currentAddUserProjectAuthority);
				}else {
					infoMessage = addUserName + " has no authority in this project. " + "<br/>" + "Select authority:";
				}
				
			//Update or add database with user and authority type.
			}else{
					req.setAttribute("Submit", null);
					AuthorityTypeBean authorityTypeBean = dao.getAuthorityTypeBean(requestedAddUserProjectAuthority, connection);
					int authorityId = authorityTypeBean.getAuthorityTypeId();
					int projectId = projectBean.getProjectId();
					int addUserId = addUserBean.getUserId();
					int authorUserId = userBean.getUserId();
						
					//if user is already in database, update
					if (currentAddUserProjectAuthority!=null) {
						
						//remove user from project if authority is remove
						if(requestedAddUserProjectAuthority.equals("< remove >")) {
						
							rows = dao.removeUserProjectAuthority(projectId, addUserId, connection);
							if(rows!=0) {
								infoMessage = "User has been removed from project.";
								
							}else {
								infoMessage = "User could not be removed from project.";
							}
						}else {
							
							rows = dao.updateUserProjectAuthority(projectId, addUserId, authorityId, authorUserId, connection);
							if(rows!=0) {
								infoMessage = "Project Authority Updated to " + requestedAddUserProjectAuthority;
								req.setAttribute("addUserProjectAuthority", requestedAddUserProjectAuthority);
								ProjectUserSummaryBean projectUserSummaryBean = dao.getProjectUserSummaryBeanForUserProject(projectName,addUserName, connection);
								req.setAttribute("projectUserSummaryBean", projectUserSummaryBean);
							}else {
								infoMessage = "Project Authority Could Not Be Updated.";
							}
							
						}
						
						
					//if user is not in database, add
					}else {
						
						if(requestedAddUserProjectAuthority.equals("< remove >")) {
							
								infoMessage = "User is not currently on project.";
								
						}else {
						
						
							rows = dao.addUserProjectAuthority(projectId, addUserId, authorityId, authorUserId, connection);
							if(rows!=0) {
								infoMessage = "Project Authority Added as " + requestedAddUserProjectAuthority;
								req.setAttribute("addUserProjectAuthority", requestedAddUserProjectAuthority);
								ProjectUserSummaryBean projectUserSummaryBean = dao.getProjectUserSummaryBeanForUserProject(projectName,addUserName, connection);
								req.setAttribute("projectUserSummaryBean", projectUserSummaryBean);
							}else {
								infoMessage = "Project Authority Could Not Be Added.";
							}
						}
						
					}
			  }
			
		//User was not an admin	
		}else {
			infoMessage = "You do not have permission to add users to this project.";
		}
	
		
		
		
		req.setAttribute("addUserToProjectMessage", infoMessage);
		
		req.getRequestDispatcher("/jsp/addUserToProject.jsp").forward(req, resp);
	}

}
