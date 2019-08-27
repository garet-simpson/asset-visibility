package com.itemtracer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	public static Connection getConnectionToDatabase() {
		Connection connection = null;

		try {

			// load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Registered!");

			// get hold of the DriverManager
			//Development mysql connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itemtracer", "root", "iamgroot");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assetvisibility", "root", "iamgroot"); 
			//Production mysql connection
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itemtrac_itemtracer2", "itemtrac_root", "iamgroot");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();

		}

		catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("Connection made to DB!");
		}
		return connection;
	}

}
