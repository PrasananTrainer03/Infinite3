package com.java.demo;

public class StExample {

	public void show() {
		System.out.println("Show Method...");
	}
	
	public static void display() {
		System.out.println("Display Method...");
	}
	
	public static void main(String[] args) {
		StExample.display();
		new StExample().show();
	}
}
