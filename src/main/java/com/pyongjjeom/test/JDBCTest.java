package com.pyongjjeom.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			String userName = "rootdev";
			String password = "1234";

			String url = "jdbc:mysql://192.168.0.131:3306/forcebewithyou";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Database connection established");
      
			System.out.println();
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Database Connection Terminated");
				} catch (Exception e) {
				}
			}
		}
	}
}
