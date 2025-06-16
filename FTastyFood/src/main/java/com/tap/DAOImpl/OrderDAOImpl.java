package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tap.utility.DBConnection;
import com.tap.DAO.OrderDAO;
import com.tap.model.Order;

public class OrderDAOImpl implements OrderDAO{

	private Order order;
	
	
	@Override
	public int addOrder(Order order) {
		
		String INSERT_QUERY = "INSERT INTO ORDER (RESTAURANTID, USERID, ORDERDATE, TOTALAMOUNT, STATUS, PAYMENTMODE , ADDRESS) VALUES (?,?,?,?,?,?,?)";
		
		int menuid = 0;
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS);) {
			
			pstmt.setInt(1, order.getRestaurantId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			pstmt.setFloat(4, order.getTotalAmount());
			pstmt.setString(5, order.getStatus());
			pstmt.setString(6, order.getPaymentMode());		
			pstmt.setString(7, order.getAddress());		
			
			int i = pstmt.executeUpdate();
			
			if (i == 0) {
				throw new SQLException("Creating order failed, no rows affected.");
			}
			
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()){
				if(generatedKeys.next()) {
					menuid = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating order failed, no id obtained.");					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return menuid;
	}

	
	
	@Override
	public Order getOrder(int orderId) {
		
		String GET_ORDER_BY_ID = "SELECT * FROM ORDER WHERE ORDERID = ?";
		
		order = null;
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ORDER_BY_ID);) {
			
			pstmt.setInt(1, orderId);
			
			ResultSet res = pstmt.executeQuery();
			
			res.next();
			
			int restaurantId = res.getInt("restaurantId");
			int userId = res.getInt("userId");
			Date orderDate = res.getDate("orderDate");
			float totalAmount = res.getFloat("totalAmount");
			String status = res.getString("status");
			String paymentMode = res.getString("paymentMode");
			int oderId = res.getInt("orderId");
			String address=res.getString("Address");
			
			order = new Order(orderId, restaurantId, userId, orderDate, totalAmount, status, paymentMode ,address);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	
	
	@Override
	public void updateOrder(Order order) {
		
		String UPDATE_USER = "UPDATE order SET restaurantId = ? ,userId = ?, totalAmount = ?, status = ?, paymentMode = ?, address = ? WHERE orderId = ?";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			
			preparedStatement.setInt(1, order.getRestaurantId());
			preparedStatement.setInt(2, order.getUserId());
			preparedStatement.setFloat(3, order.getTotalAmount());
			preparedStatement.setString(4, order.getStatus());
			preparedStatement.setString(5, order.getPaymentMode());
			preparedStatement.setString(6, order.getAddress());
			preparedStatement.setInt(7, order.getOrderId());

			
			int i = preparedStatement.executeUpdate();
			
			//System.out.println(i == 1 ? "Successfully Updated" : "Something went wrong"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderId) {
		
		String DELETE_QUERY = "DELETE FROM ORDER WHERE ORDERID = ?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);) {
			
			pstmt.setInt(1, orderId);
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i == 1 ? "Successfully Deleted" : "Something went wrong");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public List<Order> getAllUsers() {

		ArrayList<Order> orderList = new ArrayList<Order>();
		
		String GET_ALL_ORDERS = "SELECT * FROM ORDER";
		
		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();){
			
			ResultSet res = statement.executeQuery(GET_ALL_ORDERS);
			
			while(res.next()) {
				
				int orderId = res.getInt("orderId");
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				Date orderDate = res.getDate("orderDate");
				float totalAmount = res.getFloat("totalAmount");
				String status = res.getString("status");
				String paymentMode = res.getString("paymentMode");
				String address=res.getString("Address");
				
				Order order = new Order(orderId, restaurantId, userId, orderDate, totalAmount, status, paymentMode,address);
				
				orderList.add(order);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}

	
	@Override
	public List<Order> getAllOrders() {

		ArrayList<Order> orderList = new ArrayList<Order>();
		
		String GET_ALL_ORDERS = "SELECT * FROM ORDER";
		
		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();){
			
			ResultSet res = statement.executeQuery(GET_ALL_ORDERS);
			
			while(res.next()) {
				
				int orderId = res.getInt("orderId");
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				Date orderDate = res.getDate("orderDate");
				float totalAmount = res.getFloat("totalAmount");
				String status = res.getString("status");
				String paymentMode = res.getString("paymentMode");
				String address=res.getString("Address");
				
				Order order = new Order(orderId, restaurantId, userId, orderDate, totalAmount, status, paymentMode , address);
				
				orderList.add(order);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}


}