package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.utility.DBConnection;
import com.tap.DAO.OrderItemDAO;
import com.tap.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO{

	@Override
	public void addOrderItem(OrderItem orderitem) {
		
		String INSERT_QUERY = "INSERT INTO ORDERITEM (ORDERID, MENUID, QUANTITY, TOTALAMOUNT) VALUES (?,?,?,?)";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);) {
			
			pstmt.setInt(1, orderitem.getOrderId());
			pstmt.setInt(2, orderitem.getMenuId());
			pstmt.setInt(3, orderitem.getQuantity());
			pstmt.setFloat(4, orderitem.getTotalAmount());
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i == 1 ? "Successfully inserted" : "Something went wrong");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public OrderItem getOrderItem(int orderItemId) {
		
		OrderItem orderItem = null;
		
		String GET_ORDERITEM_BY_ID = "SELECT * FROM ORDERITEM WHERE ORDERITEMID = ?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ORDERITEM_BY_ID);) {
			
			pstmt.setInt(1, orderItemId);
			
			ResultSet res = pstmt.executeQuery();
			
			int orderId = res.getInt("orderId");
			int menuId = res.getInt("menuId");
			int quantity = res.getInt("quantity");
			float totalAmount = res.getInt("totalAmount");
			
			orderItem = new OrderItem(orderItemId, orderId, menuId, quantity, totalAmount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderItem;
	}

	
	
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		String UPDATE_USER = "UPDATE orderItem SET orderId = ?, menuId = ?, quantity = ?, totalAmount = ? WHERE orderItemId=?";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			
			preparedStatement.setInt(1, orderItem.getOrderId());
			preparedStatement.setInt(2, orderItem.getMenuId());
			preparedStatement.setInt(3, orderItem.getQuantity());
			preparedStatement.setInt(5, orderItem.getOrderItemId());
			preparedStatement.setFloat(4, orderItem.getTotalAmount());
		
			
			int i = preparedStatement.executeUpdate();
			
			//System.out.println(i == 1 ? "Successfully Updated" : "Something went wrong"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	
	
	@Override
	public void deleteOrderItem(int orderItemId) {
		
		String DELETE_QUERY = "DELETE FROM ORDERITEM WHERE ORDERITEMID = ?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);) {
			
			pstmt.setInt(1, orderItemId);
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i == 1 ? "OrderItem Deleted" : "Something went wrong");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public List<OrderItem> getAllOrderItems() {
		
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		
		String GET_ALL_ORDERITEMS = "SELECT * FROM ORDERITEM";
		ResultSet res=null;
		
		try(Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();) {
			
			res = statement.executeQuery(GET_ALL_ORDERITEMS);
			
			while(res.next()) {
				
				int orderItemId = res.getInt("orderItemId");
				int orderId = res.getInt("orderId");
				int menuId = res.getInt("menuId");
				int quantity = res.getInt("quantity");
				float totalAmount = res.getInt("totalAmount");
				
				OrderItem orderItem = new OrderItem(orderItemId, orderId, menuId, quantity, totalAmount);
				
				orderItemList.add(orderItem);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderItemList;
	}

}