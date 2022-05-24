

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
//import com.sun.jdi.connect.spi.Connection;

/**
 * Servlet implementation class Urban
 */
@WebServlet("servlet/Urban")
public class Urban extends HttpServlet {
	private static final long serialVersionUID = 1L;
          public static int id=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name=request.getParameter("user");
			String email=request.getParameter("mail");
			String number=request.getParameter("number");
			String date=request.getParameter("date");
			String time =request.getParameter("time");
			
			
			
			
			
			
			
			
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/Urban_Food","root","admin");  
				Statement stmt = con.createStatement();
			      //Query to get the number of rows in a table
			      String query = "select count(*) from reserve";
			      //Executing the query
			      ResultSet rs = stmt.executeQuery(query);
			      //Retrieving the result
			     while( rs.next()) {
			       id=Integer.parseInt(rs.getString(1));
			       
			     }
			     id++;
				PreparedStatement ps=con.prepareStatement(  
				"insert into reserve values(?,?,?,?,?,?)");
				    
				 
				 
				  ps.setString(1,Integer.toString(id));
				ps.setString(2,name);  
				ps.setString(3,number);  
				ps.setString(4,email);  
				ps.setString(5,date);  
				ps.setString(6, time);
				          
				int i=ps.executeUpdate(); 
				if(i>0)  
					out.print("---->>>>>>>>"); 
				RequestDispatcher rd= request.getRequestDispatcher("/thankyou.html");
				rd.include(request,response);
				
								      
				          
				}catch (Exception e2) {System.out.println(e2);}  
				          
				out.close();  
				}  
		
	}


