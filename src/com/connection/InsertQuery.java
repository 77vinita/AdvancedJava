package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertQuery {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		int result;
		//no need of result set here as we are inserting a query and not receiving any data
		
		try {
			//st = con.prepareStatement("INSERT INTO STUDENT
			//(rollNo,sname,email,addresss,age,percentage) VALUES 
			//(10,'Naina','nancy@gmail.com','Pune',23,89)");
			//the above causes DATA LEAKAGE instead use placeholder ?
			
			st = con.prepareStatement("INSERT INTO STUDENT(rollNo, sname, email, addresss, age, percentage) VALUES (?,?,?,?,?,?) ");
			
			System.out.print("Enter student roll number: ");
			st.setInt(1, sc.nextInt());
			
			System.out.print("Enter student name: ");
			st.setString(2, sc.next());
			
			System.out.print("Enter student email-id: ");
			st.setString(3, sc.next());
			st.setString(4,"Pune");
			st.setInt(5, 23);
			st.setDouble(6, 93);
			
			result=st.executeUpdate(); //save changes made by dml command, returns int value i.e no of rows or columns affected
			
			if(result > 0) {
				System.out.println("Record updated successfully.....");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
