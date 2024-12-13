package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConditionalQuery {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		ResultSet rs = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a percentage to display student with graeter percentages: ");
		
		try {
//			st = con.prepareStatement("SELECT * FROM STUDENT WHERE age BETWEEN 18 and 22");
			st = con.prepareStatement("SELECT * FROM STUDENT WHERE percentage > ?");
			st.setDouble(1, sc.nextDouble());
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
		} catch (SQLException e) {
			
		}
		sc.close();
	}

}
