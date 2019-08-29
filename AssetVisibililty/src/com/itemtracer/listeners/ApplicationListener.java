package com.itemtracer.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.itemtracer.dao.DBConnection;
import com.itemtracer.dao.MyDataSource;
import com.itemtracer.dao.MyDataSourceFactory;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("in contextDestroyed method");
		//Connection connection = (Connection)arg0.getServletContext().getAttribute("dbconnection");
		//try {
		//	connection.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("in contextinitialized method");
		
		//MyDataSource myDataSource = new MyDataSource();
		//DataSource dataSource = myDataSource.getDataSource();
	
        //arg0.getServletContext().setAttribute("dataSource", dataSource);
		
		//try {
		//	InitialContext initialContext = new InitialContext();
		//	DataSource dataSource = (DataSource)initialContext.lookup("java:comp/env/jdbc/MySQLDB");
		
		//}catch(Exception e) {
		//	e.printStackTrace();
		//}
		
		
		//Connection connection = DBConnection.getConnectionToDatabase();
		//arg0.getServletContext().setAttribute("dbconnection", connection);
		//DataSource dataSource = null;
		//MysqlDataSource mysqlDS = null;
		//mysqlDS = new MysqlDataSource();
		//mysqlDS.setURL("jdbc:mysql://localhost:3306/itemtracer");
		//mysqlDS.setUser("root");
		//mysqlDS.setPassword("iamgroot");
		//dataSource = mysqlDS;
		//arg0.getServletContext().setAttribute("dataSource", dataSource);
	}
}
