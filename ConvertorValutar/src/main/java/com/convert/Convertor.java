package com.convert;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Convertor extends HttpServlet {
	
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String valutaEuro = req.getParameter("EURO");
		String valutaLei = req.getParameter("ron");
		
		int a = Integer.parseInt(valutaLei);
		int b= Integer.parseInt(valutaEuro);
		req.setAttribute("nrEuro", a/b);
		
	//	req.setAttribute("afisLei", valutaLei);
	//	req.setAttribute("afisEuro", valutaEuro);
		req.getRequestDispatcher("convertor.jsp").forward(req, res);
	}
}
