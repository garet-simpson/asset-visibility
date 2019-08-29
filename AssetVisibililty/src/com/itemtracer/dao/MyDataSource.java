package com.itemtracer.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataSource {

	private DataSource dataSource;
	
	public MyDataSource() {
		
		
		try {
			InitialContext initialContext = new InitialContext();
			dataSource = (DataSource)initialContext.lookup("java:comp/env/jdbc/itemtracer");
	    }
	    catch (NamingException ex) {
	      ex.printStackTrace();
	    }
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


}