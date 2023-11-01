package com.afis;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Laptop  extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String laptopBrand = req.getParameter("brand");
		
		req.setAttribute("laptopAfis", laptopBrand);
		
		
		int length = laptopBrand.length();
		req.setAttribute("lengthAfis", length);
		
		String paritate;
		if(length %2 == 0)
			paritate ="par";
		else 
			paritate = "impar";
		req.setAttribute("paritateAfis", paritate);
			
		req.getRequestDispatcher("afis.jsp").forward(req, res);

		
	}

	
}
