package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signUpServlet")
public class SignUpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		UserDAOImpl udi = new UserDAOImpl();
		
		if(action.equals("add")) {
			
			User user = new User();
			
			user.setName(request.getParameter("name"));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setPhone(request.getParameter("phone"));
			user.setAddress(request.getParameter("address"));
			user.setRole(request.getParameter("role"));
			
			udi.addUser(user);
			
			response.sendRedirect("signin.jsp");
		} 
		else if (action.equals("update")) {
			
			User user = new User();
			
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setPhone(request.getParameter("phone"));
			user.setAddress(request.getParameter("address"));
			user.setEmail(request.getParameter("email"));
			user.setRole(request.getParameter("role"));
		
			int i = udi.updateUser(user);
			
			if (i == 1) {
				session.removeAttribute("user");
				user = udi.getUserbyEmail(request.getParameter("email"));
				session.setAttribute("user", user);
			}
			
			response.sendRedirect("profile.jsp");
		}
		
	}
	
}