package com.java.cms;

public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private String restaurantCity;
	private String restaurantState;
	private String restaurantEmail;
	private String restaurantMobile;
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantCity() {
		return restaurantCity;
	}
	public void setRestaurantCity(String restaurantCity) {
		this.restaurantCity = restaurantCity;
	}
	public String getRestaurantState() {
		return restaurantState;
	}
	public void setRestaurantState(String restaurantState) {
		this.restaurantState = restaurantState;
	}
	public String getRestaurantEmail() {
		return restaurantEmail;
	}
	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}
	public String getRestaurantMobile() {
		return restaurantMobile;
	}
	public void setRestaurantMobile(String restaurantMobile) {
		this.restaurantMobile = restaurantMobile;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", restaurantCity="
				+ restaurantCity + ", restaurantState=" + restaurantState + ", restaurantEmail=" + restaurantEmail
				+ ", restaurantMobile=" + restaurantMobile + "]";
	}
	
	
}
