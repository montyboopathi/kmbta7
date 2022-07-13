package com.kmbtask;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet
public class MyServlet extends HttpServlet {
	
	PreparedStatement ps; 
	
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		System.out.println(empCode);
		String empName = request.getParameter("empName");
		int empSalary = Integer.parseInt(request.getParameter("empSalary"));
		PrintWriter out = response.getWriter();
		ServletContext ctx=getServletContext();  
		Connection con=(Connection)ctx.getAttribute("mycon");  
	        System.out.println(con);
	        try {
				ps = con.prepareStatement("INSERT INTO  permanentemployee(empCode, empName,empSalary) VALUES (?,?,?)");
				ps.setInt(1,empCode);
				ps.setString(2,empName);
				ps.setInt(3,empSalary);
			} 
	        catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				ps.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	}

	
	
}
