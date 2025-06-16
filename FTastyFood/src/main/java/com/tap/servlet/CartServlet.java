package com.tap.servlet;

import java.awt.MenuItem;
import java.io.IOException;
import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;
import com.tap.model.Restaurant;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
		Cart cart = (Cart) session.getAttribute("cart");
		int currentRestaurantId = (int) session.getAttribute("restaurantId");			
		int newRestaurantId = Integer.parseInt(request.getParameter("restaurantId"));
		
		RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();
		
		Restaurant restaurant = restaurantDAOImpl.getRestaurant(newRestaurantId);
		request.setAttribute("restaurant", restaurant);
		
		if(cart == null || currentRestaurantId != newRestaurantId) {
			cart = new Cart();
		
			session.setAttribute("cart", cart);
			session.setAttribute("restaurantId", newRestaurantId);
		}
		
		String action = request.getParameter("action");
		
		try {
			if(action.equals("add")) {
				addItemToCart(request, cart);
			} else if (action.equals("update")) {
				updateCartItem(request, cart);
			} else if (action.equals("remove")) {
				removeCartItem(request, cart);
			} else {
				clearCart(cart);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
		
		} else {
			response.sendRedirect("signin.jsp");
		}
	}

	private void addItemToCart(HttpServletRequest request, Cart cart) throws ClassNotFoundException{
		
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		Menu menuItem = menuDAO.getMenu(menuId);
		
		if(menuItem != null) {
			CartItem Item = new CartItem(
			menuItem.getMenuId(),
			menuItem.getRestaurantId(),
			menuItem.getItemName(),
			menuItem.getPrice(),
			quantity);
			
			cart.addCartItem(Item);
			
		}
		
	}
	
	private void updateCartItem(HttpServletRequest request, Cart cart) {
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
		
	}
	
	private void removeCartItem(HttpServletRequest request, Cart cart) {
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);
		
	}
	
	private void clearCart(Cart cart) {
		cart.clear();
	}
		
}