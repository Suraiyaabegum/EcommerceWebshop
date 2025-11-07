package com.qa.reusableComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCPreparedStatement {

	// Java Program illustrating Prepared Statement in JDBC
		    public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Scanner sc = new Scanner(System.in);
	            System.out.println("What age do you want to search?? ");
	            int age = sc.nextInt();
                Connection con = DriverManager.getConnection("jdbc:mysql:///world", "root", "12345");
	            PreparedStatement ps = con.prepareStatement("select name from world.people where age = ?");
                ps.setInt(1, age);
	            ResultSet res = ps.executeQuery();
	            while (res.next()) {
	                System.out.println("Name : "
	                                   + res.getString(1));
	            }
	        }
            catch (SQLException e) {   System.out.println(e); }          
	        catch (ClassNotFoundException e) {   e.printStackTrace(); }
	        }
       }