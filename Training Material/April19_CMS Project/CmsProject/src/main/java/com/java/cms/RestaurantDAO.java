package com.java.cms;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantDAO {

	Connection connection;
	PreparedStatement pst;
	
	public Restaurant searchRestaurant(int restaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant where RestaurantID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantId);
		ResultSet rs = pst.executeQuery();
		Restaurant restaurant = null;
		if (rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("RestaurantID"));
			restaurant.setRestaurantName(rs.getString("RestaurantName"));
			restaurant.setRestaurantCity(rs.getString("RestaurantCity"));
			restaurant.setRestaurantState(rs.getString("RestaurantState"));
			restaurant.setRestaurantEmail(rs.getString("RestaurantEmail"));
			restaurant.setRestaurantMobile(rs.getString("RestaurantMobile"));
		}
		return restaurant;
	}
	
	public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Restaurant restaurant = null;
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		while(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("RestaurantID"));
			restaurant.setRestaurantName(rs.getString("RestaurantName"));
			restaurant.setRestaurantCity(rs.getString("RestaurantCity"));
			restaurant.setRestaurantState(rs.getString("RestaurantState"));
			restaurant.setRestaurantEmail(rs.getString("RestaurantEmail"));
			restaurant.setRestaurantMobile(rs.getString("RestaurantMobile"));
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}
}
