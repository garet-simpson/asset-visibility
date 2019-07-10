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
 * Servlet implementation class ItemLocationReportServlet
 */
@WebServlet("/itemLocationReport")
public class ItemLocationReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemLocationReportServlet() {
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
		
		// Get unique list of all part number
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		List<ItemMovementBean> partDescriptions = dao.getUniquePartNumbers(projectName, connection);
		req.setAttribute("PartDescriptions", partDescriptions);
		req.getRequestDispatcher("/jsp/itemLocationReport.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap <String, List<ItemMovementBean>> locationMap = new HashMap<>();
		
		HttpSession session = req.getSession();
		ProjectBean projectBean = (ProjectBean) session.getAttribute("project");
		String projectName = projectBean.getProjectName();
		
		String partDescription = req.getParameter("partDescription");
		String currLocation = null;
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		List<ItemMovementBean> partDescriptions = dao.getUniquePartNumbers(projectName, connection);
		req.setAttribute("PartDescriptions", partDescriptions);
		req.setAttribute("PartDescription", partDescription);
		
		List<ItemMovementBean> locations = dao.getUniqueLocations(projectName, connection);
		req.setAttribute("Locations", locations);
		
		for(ItemMovementBean location : locations) {
			currLocation = location.getDestinationLocationName();
			List<ItemMovementBean> itemMovements = dao.getMovementFromPartDescriptionAndLocation(projectName, partDescription, currLocation, connection);
			locationMap.put(currLocation, itemMovements);
		}
		
		req.setAttribute("LocationMap", locationMap);

		req.getRequestDispatcher("/jsp/itemLocationReport.jsp").forward(req, resp);
	}

}
