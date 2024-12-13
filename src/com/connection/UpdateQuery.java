package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQuery {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		int result = 0;
		
		try {
			//QUERY: update table_name set col1 = new_value where condition
			st = con.prepareStatement("UPDATE STUDENT SET rollNo=?, sname=?, email=? WHERE rollNo = 11");
			st.setInt(1,12);
			st.setString(2,"Rishi");
			st.setString(3, "rishi@gamil.com");
			
			result = st.executeUpdate();
			
			if(result > 0) {
				System.out.println("Result successfully updated !!");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
