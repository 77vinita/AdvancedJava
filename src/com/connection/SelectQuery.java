package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class SelectQuery {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		ResultSet rs = null;
		
		try
		{
//			Statement st = con.createStatement();
//			rs = st.executeQuery("SELECT * FROM student");
			
			PreparedStatement st = con.prepareStatement("SELECT * FROM student");
			rs = st.executeQuery();
			
			while(rs.next())
			{
				System.out.print(rs.getInt("rollNo")+" ");
				System.out.print(rs.getString("sname")+" ");
				System.out.print(rs.getString("email")+" ");
				System.out.print(rs.getString("addresss")+" ");
				System.out.print(rs.getInt("age")+" ");
				System.out.println(rs.getDouble("percentage"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
