package com.tcs.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class JdbcConnection {

	
	
	public Connection getConnection()
	{

	OracleDriver od = new OracleDriver();
	Connection con = null;
	String url = "jdbc:oracle:thin:@INGNRGPILPSQL01:1521:XE";
	String user ="a65core";
	String password ="a65core";
	try{
		DriverManager.registerDriver(od);
		con = DriverManager.getConnection(url, user, password) ;
	}
	catch (SQLException e) {
	  System.out.println("Database connection failed....");	
	}
	return con;

    }

}
