package com.java.cms;

import java.sql.SQLException;
import java.util.Scanner;

public class RestaurantSearchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int restaurntId;
		System.out.println("Enter RestaurantId  ");
		restaurntId = sc.nextInt();
		RestaurantDAO dao = new RestaurantDAO();
		try {
			Restaurant restaurant = dao.searchRestaurant(restaurntId);
			if (restaurant!=null) {
				System.out.println(restaurant);
			} else {
				System.out.println("Not Found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
