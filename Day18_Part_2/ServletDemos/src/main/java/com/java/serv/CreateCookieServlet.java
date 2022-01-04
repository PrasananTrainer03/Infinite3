package com.java.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCookieServlet
 */
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ckOmkar = new Cookie("Omkar", "88");
		ckOmkar.setMaxAge(1000*60*60*24);
		response.addCookie(ckOmkar);
		
		Cookie ckDinesh = new Cookie("Dinesh", "90");
		ckOmkar.setMaxAge(1000*60*60*24);
		response.addCookie(ckDinesh);
		
		Cookie ckSuchita = new Cookie("Suchita", "88");
		ckOmkar.setMaxAge(1000*60*60*24);
		response.addCookie(ckSuchita);
		
		Cookie ckDivya = new Cookie("Divya", "91");
		ckOmkar.setMaxAge(1000*60*60*24);
		response.addCookie(ckDivya);
		
		Cookie ckChandra = new Cookie("Chandra", "81");
		ckOmkar.setMaxAge(1000*60*60*24);
		response.addCookie(ckChandra);
		
		PrintWriter out = response.getWriter();
		out.println("Cookies created...");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
