package com.tap.model;

public class Menu {

	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private int price;
	private String isAvaliable;
	private float rating;
	private String imagePath;
	
	public Menu() {
		
	}

	public Menu(int menuId, int restaurantId, String itemName, String description, int price, String isAvaliable,
			float rating, String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvaliable = isAvaliable;
		this.rating = rating;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsAvaliable() {
		return isAvaliable;
	}

	public void setIsAvaliable(String isAvaliable) {
		this.isAvaliable = isAvaliable;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", resturantId=" + restaurantId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvaliable=" + isAvaliable + ", rating=" + rating
				+ ", imagePath=" + imagePath + "]";
	}
	
	
	
	
}