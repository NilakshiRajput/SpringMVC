package com.tcs.ilp.util;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil{
	private static final String DRIVERNAME  = "oracle.jdbc.driver.OracleDriver";

	private static final String URL = "jdbc:oracle:thin:@intvmoradb04:1521:ORAUNIXDB";

	private static final String PASSWORD = "tcstvm";
	private static final String USERNAME =  "TAO1_WorkQ1_17" ;

	// get a database connection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVERNAME);
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection establisted");
		} catch (ClassNotFoundException ex) {

			System.out.println("connection not establisted" + ex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		return connection;
	}

	// close database connection
	public static void closeConnection(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
		}
	}

	// close statements
	public static void closeStatement(Statement smt) {

		if (smt != null) {
			try {
				((Connection) smt).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
		}
	}

	// close prepared statements
	public static void closeStatement(PreparedStatement smt) {

		if (smt != null) {
			try {
				smt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		DatabaseUtil.getConnection();
	}
}
