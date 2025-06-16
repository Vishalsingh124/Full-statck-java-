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
import com.tap.DAO.UserDAO;
import com.tap.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) {
		
		String INSERT = "INSERT into USER (name, username, password, email, "
				+ "phone, address, role) Values(?,?,?,?,?,?,?)";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT);) {
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getRole());
			//pstmt.setDate(7, java.sql.Date.valueOf(LocalDate.now()));	
			
			int i = pstmt.executeUpdate();
			
			//System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public User getUser(int userId) {
		
		String GET_USER_BY_ID = "SELECT * from USER where userId = ?";
		
		User user = null;
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);) {
			
			preparedStatement.setInt(1, userId);
			
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()) {
				
				int id = res.getInt("userId");
				String name = res.getString("name");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String phone = res.getString("phone");
				String address = res.getString("address");
				Date createdDate = res.getDate("createdDate");
				Date lastLoginDate = res.getDate("lastLoginDate");
				
				user = new User(id, name, username, password, email, phone, address, address, createdDate, lastLoginDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	
	public User getUserbyEmail(String email) {
		
		String GET_USER_BY_ID = "SELECT * from USER where email = ?";
		
		User user = null;
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);) {
			
			preparedStatement.setString(1, email);
			
			ResultSet res = preparedStatement.executeQuery();
			
			while(res.next()) {
				
				int id = res.getInt("userId");
				String name = res.getString("name");
				String username = res.getString("username");
				String password = res.getString("password");
				String phone = res.getString("phone");
				String address = res.getString("address");
				Date createdDate = res.getDate("createdDate");
				Date lastLoginDate = res.getDate("lastLoginDate");
				
				user = new User(id, name, username, password, email, phone, address, address, createdDate, lastLoginDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	

	@Override
	public int  updateUser(User user) {
		
		String UPDATE_USER = "UPDATE USER SET username = ?, password = ?, phone = ?, address = ? WHERE EMAIL = ?";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getEmail());
			
			int i = preparedStatement.executeUpdate();
			
//			System.out.println(i == 1 ? "Successfully inserted" : "Something went wrong");
			if(i==1) {
				return i;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	


		
	
	public void updateUserByEmail(String email) {
		
		String UPDATE_USER = "UPDATE USER SET lastLoginDate = ? WHERE EMAIL = ?";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			
			preparedStatement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			preparedStatement.setString(2, email);
			
			int i = preparedStatement.executeUpdate();
			//System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void deleteUser(int userId) {
		
		String DELETE_QUERY = "DELETE FROM USER WHERE USERID = ?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);) {
			
			pstmt.setInt(1, userId);
			
			int i = pstmt.executeUpdate();
			
			System.out.println(i == 1 ? "User data Deleted" : "Failed to delete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public List<User> getAllUsers() {
		
		ArrayList<User> userList = new ArrayList<User>();
		
		String GET_ALL_USERS = "SELECT * FROM USER";
		
		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();) {
			
			ResultSet res = statement.executeQuery(GET_ALL_USERS);
			
			while(res.next()) {
				
				int userId = res.getInt("userId");
				String name = res.getString("name");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String phone = res.getString("phone");
				String address = res.getString("address");
				Date createdDate = res.getDate("createdDate");
				Date lastLoginDate = res.getDate("lastLoginDate");
				
				User user = new User(userId, name, username, password, email, phone, address, address, createdDate, lastLoginDate);
				
				userList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

}