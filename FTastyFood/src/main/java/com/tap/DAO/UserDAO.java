package com.tap.DAO;

import com.tap.model.User;

import java.util.List;

public interface UserDAO {

		void addUser(User user);
		
		User getUser(int userId);
		
		int updateUser(User userId);
		
		void deleteUser(int userId);
		
		List<User> getAllUsers();
}