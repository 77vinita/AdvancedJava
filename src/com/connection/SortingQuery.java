package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SortingQuery {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement("SELECT * FROM STUDENT ORDER BY rollNo DESC");
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println("Roll no: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2) );
				System.out.println("Email: " + rs.getString(3) );
				System.out.println("Address: " + rs.getString(4) );
				System.out.println("Age: " + rs.getInt(5));
				System.out.println("Percentage: " + rs.getDouble(6) );
				System.out.println("++++++++++++++++++++++++++++++++++");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
