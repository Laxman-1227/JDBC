package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateData {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tempdb","root","Password@123");
			System.out.println("connected");
			
			
//			Statement stmt =con.createStatement();
			
//			int rows = stmt.executeUpdate("insert into tempdb.t2 values(107,'abc7','HYD7'),(108,'abc8','HYD8') ;");
//			int rows = stmt.executeUpdate("delete from tempDB.t2 where id=108;");
//			int rows = stmt.executeUpdate("update tempDB.t2 set name = 'abcd' where id =101;");
			
			PreparedStatement ps=con.prepareStatement("insert into tempdb.t2 values(?,?,?)");
			ps.setInt(1, 109);
			ps.setString(2,"abc9");
			ps.setString(3,"HYD9");
			int rows = ps.executeUpdate();
			
			
			System.out.println(rows);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
