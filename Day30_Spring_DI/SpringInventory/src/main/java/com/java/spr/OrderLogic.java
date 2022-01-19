package com.java.spr;

import java.util.List;

public class OrderLogic {

	private List<Order> items;

	public List<Order> getItems() {
		return items;
	}

	public void setItems(List<Order> items) {
		this.items = items;
	}
	
	public void display() {
		for (Order order : items) {
			order.display();
			int value = order.getObjproduct().getQuantityAvail() - order.getQtyord();
			if (value >= 0) {
				System.out.println("Order Placed Successfully...");
				System.out.println("Bill Amount  " +order.getQtyord() * order.getObjproduct().getPrice());
			} else {
				System.out.println("Insufficent Quantity...");
				System.out.println("Order Cannot be Placed...");
			}
		}
	}
}
