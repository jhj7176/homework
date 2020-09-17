package com.bit.model;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	public class MyOracle{

		private static Connection conn;
		private static String driver="oracle.jdbc.OracleDriver";
		private static String url="jdbc:oracle:thin:@localhost:1521:xe";
		private static String user="scott";
		private static String password="tiger";

		
		
		
		private MyOracle() {
		}

		public static Connection getConnection() throws SQLException {

			if (conn == null || conn.isClosed()) {

				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(url, user, password);
			}//if

			return conn;
		}//getConnection


		
	}
	

