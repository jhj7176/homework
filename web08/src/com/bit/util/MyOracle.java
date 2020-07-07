package com.bit.util;

import java.sql.*;

public class MyOracle {

	private static Connection conn;
	private static String driver ="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user="scott";
	private static String password="tiger";

	private MyOracle() {
	}//default constructor

	public static Connection getConnection() throws SQLException {

		
		
		if(conn==null||conn.isClosed()){
			
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ojdbc14.jar Please Check");
				System.out.println("'String driver' Please Check");		
			} 	//tryCatch		
		
		}//if
		
		return conn;
	}//getConn

}//MyOracle
