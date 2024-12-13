package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteQuery {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		Scanner sc = new Scanner(System.in);
		PreparedStatement st = null;
		int result = 0;
		
		System.out.print("Enter roll number of record to be deleted: ");
		
		try {
			st = con.prepareStatement("DELETE FROM STUDENT WHERE rollNo = ?");
			st.setInt(1, sc.nextInt());
			result = st.executeUpdate();
			
			if(result > 0) {
				System.out.println("Record deleted successfully....");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
