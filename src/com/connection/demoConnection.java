package com.connection;

//Importing required classes for database connectivity
import java.sql.Connection; //Interface for managing database connection
import java.sql.DriverManager; //Class for managing database drivers
import java.sql.SQLException; //Exception handling for SQL related errors

public class demoConnection 
{
    public static void main(String[] args) 
    {
        // Define JDBC(Database) : URL, user-name, and password
        //3306: default port number used by MySQL servers for communication
    	String url = "jdbc:mysql://localhost:3306/db"; // Use correct database name
        
    	String user = "root"; // Database user-name
        
    	String password = "vinita252311"; // Database password
        
        Connection con = null; //Initialize the connection object

        try 
        {
            // Load MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver"); //Ensures MySQL driver is available in the project

            // Establish the connection
            con = DriverManager.getConnection(url, user, password);
            
            if (con != null) 
            {
                System.out.println("Connected successfully...");
            }
        } 
        
        //Handle exception if JDBC driver class is not found
        catch (ClassNotFoundException e) 
        {
            System.out.println("MySQL Driver not found. Add the connector jar to the project.");
            e.printStackTrace();
        } 
        
        //Handle SQL related exceptions (e.g. wrong credentials, database not found)
        catch (SQLException e) 
        {
            System.out.println("Connection failed! Check output console.");
            e.printStackTrace();
        } 
        
        //Ensures cleanup actions are performed
        finally 
        {
            // Close the connection
            try 
            {
                if (con != null) 
                {
                    con.close(); //closes database connection to release resources
                    System.out.println("Connection closed.");
                }
            } 
            catch (SQLException e) //Handles any exception that may occur during closing connection
            {
                e.printStackTrace();
            }
        }
    }
}
