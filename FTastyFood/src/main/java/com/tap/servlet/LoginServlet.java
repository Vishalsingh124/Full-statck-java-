package com.tap.servlet;

import java.io.IOException;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callingLogin")
public class LoginServlet extends HttpServlet {
	
	String storedPassword;
	private int count = 3;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		String password = request.getParameter("password");
		User user = userDAOImpl.getUserbyEmail(request.getParameter("email"));
			
		if (user == null) {
			RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
			request.setAttribute("errorMessage", "Account not found, Please Create an Account");
			rd.forward(request, response);
		} else {
			if(user.getPassword().equals(password)) {
				userDAOImpl.updateUserByEmail(request.getParameter("email"));
				session.setAttribute("user", user);
				response.sendRedirect("home");
			} else if(!user.getPassword().equals(password) && count > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
				request.setAttribute("errorMessage", "Incorrect password " + count + " attempts left.");
				rd.forward(request, response);			
				count--;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
				request.setAttribute("errorMessage", "Account locked, Please contact administrator");
				rd = request.getRequestDispatcher("home.jsp");

				rd.forward(request, response);	
				
			}
		}
		
	}
	
}