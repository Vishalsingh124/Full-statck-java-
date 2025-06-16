package com.tap.launch;

import java.time.LocalDate;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.Restaurant;
import com.tap.model.User;

public class Test {

	public static void main(String[] args) {
	
			
		
		
//		User u=new User(0,"manu","manu@123","1234","manu@gmail.com","1234567890","BTM", "Customer", null, null);
//		
//		User u=new User();
//		u.setName("uday");
//		u.setUsername("uday@987");
//		u.setPassword("1325");
//		u.setEmail("uday@gmail.com");
//		u.setPhone("1236549870");
//		u.setAddress("YMG");
//		u.setRole("Customer");
//		
//		UserDAOImpl udo=new UserDAOImpl();
//		pstmt.setString(1, user.getName());
//		pstmt.setString(2, user.getUsername());de
//		pstmt.setString(3, user.getPassword());
//		pstmt.setString(4, user.getEmail());
//		pstmt.setString(5, user.getPhone());
//		pstmt.setString(6, user.getAddress());
//		
//		
//		List<User> allUsers = udo.getAllUsers();
//		
//		for(User x:allUsers) {
//			System.out.println(x);
//		}
//		
//		System.out.println(u);
//		
//		------------------------------------------------------------------------------------------------------------
//		
//		Restaurant rest = new Restaurant();
//		
//		String INSERT_QUERY = "INSERT INTO RESTAURANT (NAME, ADDRESS, PHONE, CUISINETYPE, DELIVERYTIME, ADMINUSERID,"
//				+ " RATING, ISACTIVE, IMAGEPATH) VALUES (?,?,?,?,?,?,?,?,?)";
//		
//		rest.setName("BAA Foods");
//		rest.setAddress("Banglore,chennai");
//		rest.setPhone_number("1236547852");
//		rest.setCuisineType("Biriyani,Semiyaa,Ice-Cream,Papaya,PaniPuri");
//		//rest.setDeliveryTime(45);
//		//rest.setAdmineUserId(0);
//		//rest.setRating(4.5f);
//		rest.setIsActive("open");
//		rest.setImagePath("https://vmnk.gumlet.io/assets/bangalore/clove-rooftop-jayanagar/images/original/clove-rooftop-jayanagar-vpe7e.jpg");
//		rest.setRestaurantId(13);
//	
//	
//		RestaurantDAOImpl rdi=new RestaurantDAOImpl();
//		
//		rdi.deleteRestaurant(14);
//		System.out.println(r);
//		
//		
//	-----------------------------------------------------------------------------------------------------------	
//		
//		
//		OrderItem oi = new OrderItem();
//		
//		OrderItemDAOImpl oip = new OrderItemDAOImpl();
//		
//		String INSERT_QUERY = "INSERT INTO ORDERITEM (ORDERID, MENUID, QUANTITY, TOTALAMOUNT) VALUES (?,?,?,?)";
//		oi.setOrderId(7);
//		oi.setMenuId(7);
//		oi.setQuantity(7);
//		oi.setTotalAmount(777.77f);
//		oi.setOrderItemId(2);
//		
//		List<OrderItem> allOrderItems = oip.getAllOrderItems();
//		
//		for(OrderItem x:allOrderItems) {
//			System.out.println(x);
//		}
//			
//		-----------------------------------------------------------------------------------------------
//		
//		
//		Order o = new Order();
//		
//		o.setRestaurantId(200);
//		o.setUserId(200);
//		o.setTotalAmount(2500);
//		o.setOrderId(1);
//		o.setStatus();
//		o.setPaymentMode("Online");
//		
//		OrderDAOImpl oi = new OrderDAOImpl();	
//		
//		 List<Order> allUsers = oi.getAllUsers();
//		
//		for(Order x:allUsers) {
//			System.out.println(x);
//		}
//		//System.out.println(i);
//		
//		
//		pstmt.setInt(1, order.getResturantId());
//		pstmt.setInt(2, order.getUserId());
//		pstmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
//		pstmt.setFloat(4, order.getTotalAmount());
//		pstmt.setString(5, order.getStatus());
//		pstmt.setString(6, order.getPaymentMode());	
//		
//
//		--------------------------------------------------------------------------------------------------
//		
//		String INSERT_QUERY = "INSERT INTO MENU (RESTAURANTID, ITEMNAME, DESCRIPTION,"
//		+ "PRICE, ISAVAILABLE, RATINGS,IMAGEPATH) VALUES (?,?,?,?,?,?,?)";
//		
//		pstmt.setInt(1, menu.getResturantId());
//		pstmt.setString(2, menu.getItemName());
//		pstmt.setString(3, menu.getDiscription());
//		pstmt.setInt(4, menu.getPrice());
//		pstmt.setString(5, menu.getIsAvaliable());
//		pstmt.setFloat(6, menu.getRating());
//		pstmt.setString(7, menu.getImagePath());
		Menu m = new Menu();
		
//		m.setRestaurantId(2);
		m.setItemName("Pizza");
		m.setMenuId(9);
//		m.setDescription("Creamy & delicious Butter Pizar served in grilled bread Serving Size: 175gms Energy: 490.20Kcal Contains: Milk, Gluten, Soy");
//		m.setPrice(200);
//		//m.setIsAvaliable(null);
//		m.setRating(4.6f);
//		m.setImagePath("https://b.zmtcdn.com/data/dish_photos/633/6a62772c015c4b243be295494359d633.jpg?fit=around|130:130&crop=130:130;,");
		MenuDAOImpl mi = new MenuDAOImpl();
		
		mi.updateMenu(m);
		//System.out.println(menu);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}