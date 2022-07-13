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
import java.sql.ResultSet;
import java.sql.SQLException;


public class ListService extends HttpServlet {
	int empCode,empSalary;
	String empName="";
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
	        	ps = con.prepareStatement("select * employee.permanentemployee where empCode=?");
	        	ps.setInt(1, empCode);
				ps.executeQuery();
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
					
				}
				JSONObject jobj =new JSONObject();
				iobj.put("Code",empCode);
				
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
