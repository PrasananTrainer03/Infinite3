package com.java.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginDbServlet
 */
public class LoginDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Connection con = ConnectionHelper.getConnection();
			String cmd = "select count(*) cnt from Users where userName=? and Passcode=?";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(1, request.getParameter("userName"));
			pst.setString(2, request.getParameter("passWord"));
			ResultSet rs = pst.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt==1) {
				RequestDispatcher disp = request.getRequestDispatcher("Menu.html");
				disp.forward(request, response);
			} else {
				out.println("Invalid Credentials...");
				RequestDispatcher disp = request.getRequestDispatcher("LoginDb.html");
				disp.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
