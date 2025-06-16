package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.utility.DBConnection;
import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO{
	
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		String INSERT_QUERY = "INSERT INTO RESTAURANT (NAME, ADDRESS, PHONE, CUISINETYPE, DELIVERYTIME, ADMINUSERID,"
				+ " RATING, ISACTIVE, IMAGEPATH) VALUES (?,?,?,?,?,?,?,?,?)";

		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);) {
			
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhone_number());
			pstmt.setString(4, restaurant.getCuisineType());
			pstmt.setInt(5, restaurant.getDeliveryTime());
			pstmt.setInt(6, restaurant.getAdmineUserId());
			pstmt.setFloat(7, restaurant.getRating());
			pstmt.setString(8, restaurant.getIsActive());
			pstmt.setString(9, restaurant.getImagePath());
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i == 1 ? "Successfully Inserted" : "Failed to insert");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		String GET_RESTAURANT_BY_ID = "SELECT * from RESTAURANT where RestaurantId = ?";
		
		Restaurant restaurant = null;
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_RESTAURANT_BY_ID);) {
			
			preparedStatement.setInt(1, restaurantId);
			
			ResultSet res = preparedStatement.executeQuery();
			
			res.next();
			
			String name = res.getString("name");
			String address = res.getString("address");
			String phone = res.getString("phone");
			String cusineType = res.getString("cuisineType");
			int deliveryTime = res.getInt("deliveryTime");
			String offers = res.getString("offers");
			int adminUserId = res.getInt("adminUserId");
			float rating = res.getFloat("Rating");
			String isActive = res.getString("isActive");
			String imagePath = res.getString("imagePath");
			
			restaurant = new Restaurant(restaurantId, name, address, phone, cusineType, deliveryTime, adminUserId, rating, isActive, imagePath, offers);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurant;
	}

	
	
	
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		
		String UPDATE_USER = "UPDATE RESTAURANT SET name = ? ,address = ? ,phone = ? ,cuisineType = ? ,isActive = ? ,imagePath = ?  WHERE restaurantId = ?";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			
			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getAddress());
			preparedStatement.setString(3, restaurant.getPhone_number());
			preparedStatement.setString(4, restaurant.getCuisineType());
			preparedStatement.setString(5, restaurant.getIsActive());
			preparedStatement.setString(6, restaurant.getImagePath());
			preparedStatement.setInt(7, restaurant.getRestaurantId());
			
			
			int i = preparedStatement.executeUpdate();
			
			//System.out.println(i == 1 ? "Successfully Updated" : "Failed to Update");
			//System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	@Override
	public void deleteRestaurant(int RestaurantId) {
		// TODO Auto-generated method stub
		String DELETE_QUERY = "DELETE FROM RESTAURANT WHERE RESTAURANTID = ?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);) {
			
			pstmt.setInt(1, RestaurantId);
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i == 1 ? "Successfully Deleted" : "Failed to Delete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		
		ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
		
		String GET_ALL_Restaurants = "SELECT * FROM RESTAURANT";
		
		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();) {
			
			ResultSet res = statement.executeQuery(GET_ALL_Restaurants);
			
			while(res.next()) {
				
				int restaurantId = res.getInt("restaurantId");
				String name = res.getString("name");
				String address = res.getString("address");
				String phone = res.getString("phone");
				String cuisineType = res.getString("cuisineType");
				int deliveryTime = res.getInt("deliveryTime");
				String offers = res.getString("offers");
				int adminUserId = res.getInt("adminUserId");
				Float rating = res.getFloat("rating");
				String isActive = res.getString("isActive");
				String imagePath = res.getString("imagePath");
				
				Restaurant restaurant = new Restaurant(restaurantId, name, address, phone, cuisineType, deliveryTime, adminUserId, rating, isActive, imagePath, offers);
				
				restaurantList.add(restaurant);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurantList;
	}

	 
	 
}