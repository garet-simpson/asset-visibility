package com.itemtracer.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itemtracer.beans.PartBean;
import com.itemtracer.beans.PartTypeBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.beans.UserBean;
import com.itemtracer.dao.ApplicationDao;

@WebServlet("/newPart")
public class NewPartServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		ArrayList<PartTypeBean> partTypes = dao.getPartTypes(connection);
		req.setAttribute("partTypes", partTypes);
		
		req.getRequestDispatcher("/jsp/newPart.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		ArrayList<PartTypeBean> partTypes = dao.getPartTypes(connection);
		req.setAttribute("partTypes", partTypes);
		String partTypeName = req.getParameter("newPartTypeName");
		PartTypeBean partType = new PartTypeBean();
		for (PartTypeBean partTypeCnt:partTypes) {
			if(partTypeCnt.getPartType().equals(partTypeName)){
				partType = partTypeCnt;
			}
		}
		req.setAttribute("partType", partType);
		
		HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		ProjectBean project = (ProjectBean) session.getAttribute("project");
		int authorUserId = user.getUserId();
		

		// collect all form data
		String partNumber = req.getParameter("newPartNumber");
		String drawingNumber = req.getParameter("newDrawingNumber");
		int partTypeId = partType.getPartTypeId();
		String partDescription = req.getParameter("newPartDescription");
		String cageCode = req.getParameter("newCageCode");
		String manufacturer = req.getParameter("newManufacturer");

	
	
		// fill it up in a User bean
		PartBean part = new PartBean();
		part.setProjectId(project.getProjectId());
		part.setPartNumber(partNumber);
		part.setDrawingNumber(drawingNumber);
		part.setPartTypeId(partTypeId);
		part.setPartDescription(partDescription);
		part.setCageCode(cageCode);
		part.setManufacturer(manufacturer);
		part.setAuthorUserId(authorUserId);
		
		String infoMessage = null;
		infoMessage = part.validate();
		if(infoMessage == null) {
		// call DAO layer and save the user object to DB

			int rows = dao.addPart(part, connection);
			
			// prepare an information message for user about the success or failure of the operation
			if(rows==0){
				infoMessage="Sorry, an error occurred!";
			}
			else{
				
				part = dao.getPartBeanFromPartNumber(part.getPartNumber(), connection);
				infoMessage="New Part Added";
				req.setAttribute("newPart", part);
				
			}
		}
		req.setAttribute("part", part);
		req.setAttribute("newPartMessage", infoMessage);
		req.getRequestDispatcher("/jsp/newPart.jsp").forward(req, resp);
				
	}


	
}
