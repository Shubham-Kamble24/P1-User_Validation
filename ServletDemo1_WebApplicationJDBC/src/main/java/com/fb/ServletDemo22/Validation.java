package com.fb.ServletDemo22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Validation {
	
	//this is a simple java class which validate username and password , it is not servlet class.
	
	String username;   //instance variable
	String password;
	
	public Validation() {  //parameterless constructor
		
		
	}
	
	public Validation ( String username, String password) {
		
		this.username = username;   // parametarised constructor
		this.password = password;
		
	}
	
	public boolean isValid() {  
		
		//method that validates user name & password with help of Validation class.
		
/*	      if(username.equals("admin")&& password.equals("admin123")) {
		    return true;	
	         }*/
		  
		
		try {
				
			Class.forName("com.mysql.cj.jdbc.Driver");//step:1
			
			System.out.println("driver loaded");

		
		    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/infodb",
				"root","Shubham@@@123");  //Step:2

		    String query = "select * from users where Username= ? and Password =?; ";    
		
		    PreparedStatement ps = conn.prepareStatement(query); //Step:3
		    
		    System.out.println("statement created");
		
		    System.out.println("Query Written :"+query);
		    
		    ps.setString(1, this.username);  // sets the vallue or send the value to query??
		    ps.setString(2, this.password);
		    
		    System.out.println("query completed by ps.set()statement:"+ps);
		
		    ResultSet rs = ps.executeQuery();
		   
		    
	         if(rs.next()) {
		    	return true;
		    	
		    }else return false;
	    
		
		}
	    catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return false;
	}
}
	       
	 
