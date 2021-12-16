package com.java.lamb;

interface IDemo {
	void sayHello();
}
public class MethodRefEx {

	public static void display() {
		System.out.println("Welcome to JDK 1.8 New Features...");
	}
	
	public static void main(String[] args) {
		IDemo demo = MethodRefEx::display;
		demo.sayHello();
	}
}
