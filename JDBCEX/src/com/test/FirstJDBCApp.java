package com.test;


import java.sql.*;

public class FirstJDBCApp {

	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		
		/*
		 * step1 load driver class
		 * step2 get connection by passing db url, username, password
		 * step3 get statement Obj from connect (query)
		 * step4 execute stmt
		 */
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tempdb","root","Password@123");
			System.out.println("connected");
			
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tempDB.t2;");
			System.out.println("ID "+"NAME "+"ADDRESS");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		
		
		

	}

}
