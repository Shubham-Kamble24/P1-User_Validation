package com.fb.ServletDemo22;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginn")
public class LoginToServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("user"); /*this will recive the username from Web form (i.e Index.html file)*/
		String pwd = request.getParameter("pass");
		
//reponse.getWriter(): method will allow us to send the response to client(browser).
		PrintWriter pw = response.getWriter();
		
		//pw.println("user name recived from client:"+ name);
		//pw.println("Password name recived from client:"+ pwd);
		
		//following line will be display on server's console , & not on web browser 
		
		System.out.println("Helloo Web From Server.... ");
    	System.out.println("Username froom client:" +name);
		System.out.println("Passwordfroom client:" +pwd);
		
		
	/* we can not direct write on web browser , we need to create the object of PrintWriter Class ,
	 *  because object of PrintWriter class can send character string to client side (browser)  */
	
	//	PrintWriter pw = response.getWriter();
//	    pw.println("<h1> Hello web from server to client </h1>");// our response can be HTML to show on browser
	    
// 	    pw.write("pw.write & pw.print both are same ");
	    
	    
      Validation v = new Validation(name, pwd);  // creating object of Validation class from request input values
		
		if(v.isValid()) {
			
			pw.println("Welcome To Web Page!!!");    /*this is actual part of business logic which we written 
			                                                      inside Validation Class*/
			
			
		}else {
			
			pw.println("You are not eligible User");
			pw.println("Username Or PAssword Incorrdct");
		
		}
		
		
	    
	    
		
		
		
		
		
	}
	
	

}
