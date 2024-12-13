package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchRecordByID {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null; // used to hold and access data retrieved from the database query

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student roll no: ");

		try {
			st = con.prepareStatement("SELECT * FROM STUDENT WHERE rollNo = ?"); // this method is used to create a PreparedSattement
			// object which allows to execute parameterized queries
			
			st.setInt(1, sc.nextInt());
			rs = st.executeQuery();

			while (rs.next()) {
				System.out.println("Roll no: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2) );
				System.out.println("Email: " + rs.getString(3) );
				System.out.println("Address: " + rs.getString(4) );
				System.out.println("Age: " + rs.getInt(5));
				System.out.println("Percentage: " + rs.getDouble(6) );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
