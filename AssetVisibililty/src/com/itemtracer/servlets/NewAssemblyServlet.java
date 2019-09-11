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

import com.itemtracer.beans.AlternateCodeBean;
import com.itemtracer.beans.AssemblyBean;
import com.itemtracer.beans.PartBean;
import com.itemtracer.beans.PartTypeBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.beans.UserBean;
import com.itemtracer.dao.ApplicationDao;

@WebServlet("/newAssembly")
public class NewAssemblyServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ProjectBean project = (ProjectBean) session.getAttribute("project");
		UserBean user = (UserBean) session.getAttribute("user");
		
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		ArrayList<AlternateCodeBean> alternateCodes = dao.getAlternateCodes(connection);
		req.setAttribute("alternateCodes", alternateCodes);
		ArrayList<PartBean> parts = dao.getParts(project, connection);
		req.setAttribute("parts", parts);
		
		
		req.getRequestDispatcher("/jsp/newAssembly.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		ProjectBean project = (ProjectBean) session.getAttribute("project");
		UserBean user = (UserBean) session.getAttribute("user");
		
		
		ApplicationDao dao = new ApplicationDao();
		Connection connection = (Connection)getServletContext().getAttribute("dbconnection");
		ArrayList<AlternateCodeBean> alternateCodes = dao.getAlternateCodes(connection);
		req.setAttribute("alternateCodes", alternateCodes);
		ArrayList<PartBean> parts = dao.getParts(project, connection);
		req.setAttribute("parts", parts);
		
		String parentPartNumber = req.getParameter("parentPartNumber");
		PartBean parentPart = dao.getPartBeanFromPartNumber(parentPartNumber, connection);
		req.setAttribute("parentPart", parentPart);
		String childPartNumber = req.getParameter("childPartNumber");
		PartBean childPart = dao.getPartBeanFromPartNumber(childPartNumber, connection);
		req.setAttribute("childPart", childPart);
		
		String revision = req.getParameter("revision");
		String itemNumber = req.getParameter("itemNumber");
		String referenceDesignator = req.getParameter("referenceDesignator");
		String alternateCode = req.getParameter("alternateCode");
		AlternateCodeBean alternateCodeBean = dao.getAlternateCodeBean(alternateCode,connection);
		req.setAttribute("alternateCode", alternateCode);
		String quantity = req.getParameter("quantity");
		
		AssemblyBean assembly = new AssemblyBean();
		assembly.setProjectId(project.getProjectId());
		assembly.setParentPartId(parentPart.getPartId());
		assembly.setChildPartId(childPart.getPartId());
		assembly.setRevision(revision);
		assembly.setItemNumber(itemNumber);
		assembly.setReferenceDesignator(referenceDesignator);
		assembly.setAlternateCodeId(alternateCodeBean.getAlternateCodeId());
		assembly.setQuantity(quantity);
		assembly.setAuthorUserId(user.getUserId());
		
		
		String infoMessage = null;
		infoMessage = assembly.validate();
		if(infoMessage == null) {
		// call DAO layer and save the user object to DB

			int rows = dao.addAssembly(assembly, connection);
			
			// prepare an information message for user about the success or failure of the operation
			if(rows==0){
				infoMessage="Sorry, an error occurred!";
			}
			else{
				
				AssemblyBean newAssembly = dao.getAssemblyBean(assembly, connection);
				infoMessage="New Assembly Added";
				req.setAttribute("newAssembly", newAssembly);
				
			}
		}
		req.setAttribute("assembly", assembly);
		req.setAttribute("newAssemblyMessage", infoMessage);
		req.getRequestDispatcher("/jsp/newAssembly.jsp").forward(req, resp);
				
	}


	
}
