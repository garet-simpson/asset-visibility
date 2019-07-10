package com.itemtracer.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itemtracer.beans.ItemMovementBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.dao.ApplicationDao;

/**
 * Servlet implementation class ItemQuantityReportServlet
 */
@WebServlet("/itemQuantityReport")
public class ItemQuantityReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemQuantityReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ProjectBean projectBean = (ProjectBean) session.getAttribute("project");
		String projectName = projectBean.getProjectName();

		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		
		HashMap <String, Integer> partDescriptionCounter = new HashMap<>();
		partDescriptionCounter = dao.getQuantityByPartDescription(projectName, connection);
		req.setAttribute("PartDescriptionCounter", partDescriptionCounter);
		
		HashMap <ItemMovementBean, Integer> partNumberCounter = new HashMap<>();
		partNumberCounter = dao.getQuantityByPartNumber(projectName, connection);
		req.setAttribute("PartNumberCounter", partNumberCounter);
		
		req.getRequestDispatcher("/jsp/itemQuantityReport.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
