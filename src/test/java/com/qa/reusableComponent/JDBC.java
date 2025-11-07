package com.qa.reusableComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		// Java program to implement a simple JDBC application
		// Database URL, username, and password
		// Replace with your database name
		   String url= "jdbc:mysql://localhost:3306/your_database";
           String username = "your_username";
           String password = "your_password";

		 // Updated query syntax for modern databases
		   String query = "INSERT INTO students (id, name) VALUES (109, 'bhatt')";
		            
         // Establish JDBC Connection
	        try {
	          
	            // Load Type-4 Driver
	            // MySQL Type-4 driver class
	            Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish connection
	            Connection c = DriverManager.getConnection(url, username, password);
	            // Create a statement
	            Statement st = c.createStatement();
	            // Execute the query
	            int count = st.executeUpdate(query);
	            String sql = "SELECT * FROM people";
	            ResultSet rs = st.executeQuery(sql);
	            
	            System.out.println("Number of rows affected by this query: "+ count);
	            // Close the connection
	            st.close();
	            c.close();
	            System.out.println("Connection closed.");
	        }      
		        catch (ClassNotFoundException e) {
		            System.err.println("JDBC Driver not found: "
		                               + e.getMessage());
		        }
		        catch (SQLException e) {
		            System.err.println("SQL Error: "
		                               + e.getMessage());
		        }
		    }}