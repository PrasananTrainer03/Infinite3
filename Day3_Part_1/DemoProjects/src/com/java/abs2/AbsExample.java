package com.java.abs2;

public class AbsExample {
	public static void main(String[] args) {
		Animal[] arr = new Animal[] {
			new Lion(),
			new Crocodile()
		};
		for (Animal animal : arr) {
			animal.name();
			animal.type();
		}
	}
}
