package com.java.demo;

public class StCon {

	static {
		System.out.println("Static Constructor...");
	}
	
	StCon() {
		System.out.println("General Constructor...");
	}
	
	public static void main(String[] args) {
		StCon obj = new StCon();
	}
}
