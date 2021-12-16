package com.java.lamb;

interface IHello {
	void sayHello();
}

public class Lambda1 {
	public static void main(String[] args) {
		IHello h1 = () -> {
			System.out.println("Welcome to Lambda Expression...");
		};
		
		IHello h2 = () -> {
			System.out.println("Hi I am Prasanna...Trainer");
		};
		
		IHello h3 = () -> {
			System.out.println("Hi We are from Infinite...");
		};
		h1.sayHello();
		h2.sayHello();
		h3.sayHello();
	}
}
