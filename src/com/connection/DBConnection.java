 package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public static Connection getConnection()
	{
		String url ="jdbc:mysql://localhost:3306/db";
		String userName = "root";
		String passsword = "vinita252311";
		
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,passsword);
			
			if(con != null)
			{
				System.out.println("Connected successfully..");
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("MySQL Driver not found. Add the connector jar to the project");;
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("Connection failed");
			e.printStackTrace();
		}

		return con;
	}
}
