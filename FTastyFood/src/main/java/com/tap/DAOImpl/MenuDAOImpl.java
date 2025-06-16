package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.utility.DBConnection;
import com.tap.model.Menu;

public class MenuDAOImpl implements MenuDAO{

	@Override
	public void addMenu(Menu menu) {

		String INSERT_QUERY = "INSERT INTO MENU (RESTAURANTID, ITEMNAME, DESCRIPTION,"
				+ "PRICE, ISAVAILABLE, RATING,IMAGEPATH) VALUES (?,?,?,?,?,?,?)";
	
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);) {
			
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setInt(4, menu.getPrice());
			pstmt.setString(5, menu.getIsAvaliable());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setString(7, menu.getImagePath());
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i == 1 ? "Menu added successfully" : "Something went wrong!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public Menu getMenu(int menuId) {
		
		Menu menu = null;
		
		String GET_MENU = "SELECT * FROM MENU WHERE MENUID = ? ";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_MENU);) {
			
			pstmt.setInt(1, menuId);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int restaurantId = res.getInt("restaurantId");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				int price = res.getInt("price");
				String isAvailable = res.getString("isAvailable");
				float ratings = res.getFloat("rating");
				String imagePath = res.getString("imagePath");
				
				menu = new Menu(menuId, restaurantId, itemName, description, price, isAvailable, ratings, imagePath);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}

	
	
	@Override
	public void updateMenu(Menu menu) {
		
		String UPDATE_USER = "UPDATE menu SET itemName = ?, description = ?, price = ?, isAvailable = ?, imagePath = ? WHERE menuId = ?";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			
			preparedStatement.setString(1, menu.getItemName());
			preparedStatement.setString(2, menu.getDescription());
			preparedStatement.setInt(3, menu.getPrice());
			preparedStatement.setString(4, menu.getIsAvaliable());
			preparedStatement.setString(5, menu.getImagePath());
			preparedStatement.setInt(6, menu.getMenuId());
			
			int i = preparedStatement.executeUpdate();
			
			//System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public void deleteMenu(int menuId) {
		
		String DELETE_QUERY = "DELETE FROM MENU WHERE MENUID = ?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);) {
			
			pstmt.setInt(1, menuId);
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i == 1 ? "Menu deleted" : "Something went wrong!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public List<Menu> getAllMenus() {

		ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		String GET_ALL_MENUS = "SELECT * FROM MENU";
		
		try(Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();) {
			
			ResultSet res = statement.executeQuery(GET_ALL_MENUS);
			
			while(res.next()) {
				
				int menuid = res.getInt("menuId");
				int restaurantId = res.getInt("restaurant");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				int price = res.getInt("price");
				String isAvailable = res.getString("isAvailable");
				float ratings = res.getFloat("rating");
				String imagePath = res.getString("imagePath");
				
				 Menu menu = new Menu(menuid, restaurantId, itemName, description, price, isAvailable, ratings, imagePath);
				
				 menuList.add(menu);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return menuList;
	}
	
	

	

	public List<Menu> getRestaurantMenu(int restaurantId) {
		
		Menu menu = null;

		ArrayList<Menu> menulist = new ArrayList<Menu>();

		String GET_MENU = "SELECT * FROM MENU WHERE RESTAURANTID = ? ";

		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_MENU);) {

			pstmt.setInt(1, restaurantId);

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				int menuId = res.getInt("menuId");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				int price = res.getInt("price");
				String isAvailable = res.getString("isAvailable");
				float ratings = res.getFloat("rating");
				String imagePath = res.getString("imagePath");

				menu = new Menu(menuId, restaurantId, itemName, description, price, isAvailable, ratings, imagePath);

				menulist.add(menu);	

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menulist;
	}

	
	

}
