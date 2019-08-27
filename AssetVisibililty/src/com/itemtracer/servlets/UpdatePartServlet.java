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
import javax.swing.JOptionPane;

import com.itemtracer.beans.PartBean;
import com.itemtracer.beans.PartTypeBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.beans.UserBean;
import com.itemtracer.dao.ApplicationDao;

@WebServlet("/updatePart")
public class UpdatePartServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

		HttpSession session = req.getSession();
		ProjectBean project = (ProjectBean) session.getAttribute("project");
		ArrayList<PartBean> parts = dao.getParts(project, connection);
		req.setAttribute("parts", parts);
		
		req.getRequestDispatcher("/jsp/updatePart.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PartTypeBean partType = new PartTypeBean();
		String infoMessage = null;
		String isUpdate = req.getParameter("update");
		String isDelete = req.getParameter("delete");
		String isSaveAs = req.getParameter("saveAs");
		
		String partTypeName = null;
		ArrayList<PartTypeBean> partTypes = new ArrayList<>();
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		ProjectBean project = (ProjectBean) session.getAttribute("project");
		ArrayList<PartBean> parts = dao.getParts(project, connection);
		req.setAttribute("parts", parts);
		String partNumber = req.getParameter("partNumber");
		PartBean part = new PartBean();
		for (PartBean partCnt:parts) {
			if(partCnt.getPartNumber().equals(partNumber)){
				part = partCnt;
				req.setAttribute("part", part);
			}
		}
		
		
		
		
		if(part!=null) {
			partTypes = dao.getPartTypes(connection);
			req.setAttribute("partTypes", partTypes);
			partTypeName = part.getPartTypeName();
			for (PartTypeBean partTypeCnt:partTypes) {
				if(partTypeCnt.getPartType().equals(partTypeName)){
					partType = partTypeCnt;
				}
			}
			
			
			req.setAttribute("partType", partType);
			
		}
		
		
		if(isUpdate!=null) {
			
			
			if(part.getPartTypeName()!=req.getParameter("partTypeName")) {
				partTypeName = req.getParameter("partTypeName");
				for (PartTypeBean partTypeCnt : partTypes) {
					if(partTypeCnt.getPartType().equals(partTypeName)){
						partType = partTypeCnt;
					}
				}
				req.setAttribute("partType", partType);
			}
			
			int authorUserId = user.getUserId();
			
			
			
			// collect all form data
			String drawingNumber = req.getParameter("drawingNumber");
			int partTypeId = partType.getPartTypeId();
			String partDescription = req.getParameter("partDescription");
			String cageCode = req.getParameter("cageCode");
			String manufacturer = req.getParameter("manufacturer");
	
		
		
			// fill it up in a bean
			
			part.setProjectId(project.getProjectId());
			part.setPartNumber(partNumber);
			part.setDrawingNumber(drawingNumber);
			part.setPartTypeId(partTypeId);
			part.setPartDescription(partDescription);
			part.setCageCode(cageCode);
			part.setManufacturer(manufacturer);
			part.setAuthorUserId(authorUserId);
			
			
			infoMessage = part.validate();
			if(infoMessage == null) {
			// call DAO layer and save the user object to DB
	
				int rows = dao.updatePart(part, connection);
				
				// prepare an information message for user about the success or failure of the operation
				if(rows==0){
					infoMessage="Sorry, an error occurred!";
					part = dao.getPartBeanFromPartNumber(part.getPartNumber(), connection);
					req.setAttribute("part", part);
				}
				else{
					
					PartBean updatePart = dao.getPartBeanFromPartNumber(part.getPartNumber(), connection);
					infoMessage="Part Updated";
					req.setAttribute("part", updatePart);
					req.setAttribute("updatePart", updatePart);
				}
			}
		}
		
		if(isSaveAs!=null) {
			
			part = dao.getPartBeanFromPartNumber(part.getPartNumber(), connection);
			req.setAttribute("part", part);
			req.getRequestDispatcher("/jsp/newPart.jsp").forward(req, resp);
			
		}
		
		
		if(isDelete!=null) {
			
			part.setProjectId(project.getProjectId());
			int rows = dao.deletePart(part, connection);
			
			// prepare an information message for user about the success or failure of the operation
			if(rows==0){
				
				infoMessage="Sorry, an error occurred!";

			}
			else{
				
				infoMessage="Part Deleted";
				req.setAttribute("part", null);

			}
			
		}
		req.setAttribute("updatePartMessage", infoMessage);
		req.getRequestDispatcher("/jsp/updatePart.jsp").forward(req, resp);
				
	}


	
}
