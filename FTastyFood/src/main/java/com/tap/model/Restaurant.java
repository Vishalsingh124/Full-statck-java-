package com.tap.model;


public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String address;
	private String phone_number;
	private String cuisineType;
	private int deliveryTime;
	private int adminUserId;
	private float rating;
	private String isActive;
	private String imagePath;
	private String offers;
	
	public Restaurant() {
		
	}

	public Restaurant(int restaurantId, String name, String address, String phone_number, String cuisineType,
			int deliveryTime, int admineUserId, float rating, String isActive, String imagePath,String offers) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = admineUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
		this.offers=offers;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getAdmineUserId() {
		return adminUserId;
	}

	public void setAdmineUserId(int admineUserId) {
		this.adminUserId = admineUserId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String offers) {
		this.imagePath = imagePath;
	}
	
	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}
	
	
	@Override
	public String toString() {
		return restaurantId+" "+ name+" "+ address+" "+ phone_number+" "+cuisineType+" "+deliveryTime+" "+ adminUserId+" "+rating+" "+isActive+" "+offers;
	}
	
	
	

}