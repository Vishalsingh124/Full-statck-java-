package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.DAO.OrderDAO;
import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet{

	private OrderDAO orderDAO;
	private OrderItemDAOImpl orderItemDAOImpl;

	@Override
	public void init() throws ServletException {

		try {
			orderDAO = new OrderDAOImpl();
			orderItemDAOImpl = new OrderItemDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to initialize OrderDAO", e);
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		
		if (cart != null && user != null && !cart.getItem().isEmpty()) {
			
			String paymentMethod = request.getParameter("paymentMethod");
			String address = request.getParameter("fullName") + " " +request.getParameter("phoneNumber") +
							 " " + request.getParameter("houseNo") +" " + request.getParameter("address") + 
							 " " + request.getParameter("city") + " " + request.getParameter("pincode"); 
			
			Order order = new Order();
			order.setRestaurantId((int)session.getAttribute("restaurantId"));
			order.setUserId(user.getUser_id());
			order.setPaymentMode(paymentMethod);
			order.setAddress(address);
			order.setStatus("Confirmed");
			
			float totalAmount = 0;
			for (CartItem item : cart.getItem().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
			}
			order.setTotalAmount(totalAmount);
			
			int orderId = orderDAO.addOrder(order);
			order.setOrderId(orderId);
			for (CartItem item : cart.getItem().values()) {
				
				OrderItem oi = new OrderItem();
				
				oi.setOrderId(orderId);
				oi.setMenuId(item.getItemId());
				oi.setQuantity(item.getQuantity());
				oi.setTotalAmount(item.getPrice()*item.getQuantity());
				
				orderItemDAOImpl.addOrderItem(oi);
			}
			
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			response.sendRedirect("order_confirmation.jsp");
		} else {
			response.sendRedirect("cart.jsp");
		}
	}
	
}