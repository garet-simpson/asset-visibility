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

import com.itemtracer.beans.ItemMovementBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.dao.ApplicationDao;

/**
 * Servlet implementation class StockListingReportServlet
 */
@WebServlet("/stockListingReport")
public class StockListingReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockListingReportServlet() {
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
		List<ItemMovementBean> locations = dao.getUniqueLocations(projectName, connection);
		req.setAttribute("Locations", locations);
		req.getRequestDispatcher("/jsp/stockListingReport.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ProjectBean projectBean = (ProjectBean) session.getAttribute("project");
		String projectName = projectBean.getProjectName();
		
		String location = req.getParameter("location");
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		List<ItemMovementBean> locations = dao.getUniqueLocations(projectName, connection);
		req.setAttribute("Locations", locations);
		req.setAttribute("Location", location);
		

		List<ItemMovementBean> itemMovements = dao.getMovementsFromLocation(projectName, location, connection);
		req.setAttribute("ItemMovements", itemMovements);

		req.getRequestDispatcher("/jsp/stockListingReport.jsp").forward(req, resp);
	}

}
