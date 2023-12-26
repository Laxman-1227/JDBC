package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tempdb","root","Password@123");
			System.out.println("connected");
			
			Statement stmt = con.createStatement();
//			stmt.executeUpdate("create table tempdb.credentials(username varchar(20), password varchar(30))");
//			int rows = stmt.executeUpdate("insert into tempdb.credentials values('abc','pass123') ;");
//			
//			if(rows >0) {
//				System.out.println("data created");
//			}
//			else {
//				System.out.println("data creation failed");
//			}
			
			
//			ResultSet rs = stmt.executeQuery("select * from tempDB.credentials where username ='abc' -- and password='fgsdfgdfsgfd';");
//			if(rs.next()) {
//				System.out.println("login suucess");
//			}else {
//				System.out.println("login failed");
//			}
//			
			
			PreparedStatement ps=con.prepareStatement("select * from tempDB.credentials where username =? and password=?;");
			ps.setString(1,"abc");
			ps.setString(2,"pass123");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("login suucess");
			}else {
				System.out.println("login failed");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 

	}

}
