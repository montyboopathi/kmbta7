package com.kmbtask;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteService extends HttpServlet {
	PreparedStatement ps; 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		System.out.println(empCode);
		PrintWriter out = response.getWriter();
		ServletContext ctx=getServletContext();  
		Connection con=(Connection)ctx.getAttribute("mycon");  
	        System.out.println(con);
	        try {
	        	ps = con.prepareStatement("DELETE  FROM employee.permanentemployee where empCode="+empCode+";");
				ps.executeUpdate();
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
