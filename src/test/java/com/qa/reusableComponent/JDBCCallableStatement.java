package com.qa.reusableComponent;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCallableStatement {
	       // Java Program illustrating Callable Statement in JDBC

		    public static void main(String[] args) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql:///world", "root", "12345");
		            CallableStatement cs = con.prepareCall("{call GetPeopleInfo()}");
		            ResultSet res = cs.executeQuery();
		            while (res.next()) {
		                System.out.println("Name : " + res.getString("name"));
		                System.out.println("Age : " + res.getInt("age"));
		            }
		            res.close();
		            cs.close();
		            con.close();
		        } 
		        catch (SQLException e) { e.printStackTrace(); }
		        catch (ClassNotFoundException e) {  e.printStackTrace(); }

		    }
}