package com.itemtracer.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.itemtracer.dao.MyDataSource;

public class ConnectionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//pre-processing
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession();
		DataSource dataSource = (DataSource) session.getAttribute("dataSource");
		
		if(dataSource == null) {
			MyDataSource myDataSource = new MyDataSource();
			dataSource = myDataSource.getDataSource();
			session.setAttribute("dataSource",dataSource);
		}
		
		Connection connection = (Connection) request.getServletContext().getAttribute("dbconnection");
		if(connection == null) {
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			request.getServletContext().setAttribute("dbconnection", connection);
		}
		
		
		chain.doFilter(request, res);
		//post-processing
		
		
		//connection = (Connection) request.getServletContext().getAttribute("dbConnection");
		
		//if (connection != null) {
            //try {
            	//connection.close();
            //} catch (SQLException e) {
                // ignore, as we can't do anything about it here
            //}

            //connection = null;
        //}
		
		//request.getServletContext().setAttribute("dbConnection", null);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
