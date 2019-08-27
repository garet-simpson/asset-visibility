package com.itemtracer.dao;

import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataSourceFactory {


	public static DataSource getMySQLDataSource() {
		MysqlDataSource mysqlDS = null;
		mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("jdbc:mysql://localhost:3306/itemtracer"); 
		mysqlDS.setUser("root"); 
		mysqlDS.setPassword("iamgroot"); 
		
		return mysqlDS;
	}
	
}