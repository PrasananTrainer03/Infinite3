package com.java.lamb;

@FunctionalInterface
interface Test {
	void show();
}

public class TestDemo {

	public static void main(String[] args) {
		Test obj1 = () -> {
			System.out.println("Show Method from Functional Interface...");
		};
		obj1.show();
	}
}
