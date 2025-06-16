package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		session.setAttribute("restaurantId", restaurantId);
		
		RestaurantDAOImpl restaurantImpl = new RestaurantDAOImpl();
		
		Restaurant restaurant = restaurantImpl.getRestaurant(restaurantId);
		
		req.setAttribute("restaurant", restaurant);
		
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		
		List<Menu> restaurantMenu = menuDAO.getRestaurantMenu(restaurantId);
		
//		for (Menu menu : restaurantMenu) {
//			System.out.println(menu);
//		}
		
		req.setAttribute("restaurantMenu", restaurantMenu);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("menu.jsp");
		
		requestDispatcher.forward(req, resp);
		
	}
	
}