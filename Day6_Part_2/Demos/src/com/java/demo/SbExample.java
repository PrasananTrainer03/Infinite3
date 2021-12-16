package com.java.demo;

public class SbExample {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Welcome to Java Programming...");
		System.out.println(sb);
		sb.append("Trainer is Prasanna...");
		System.out.println(sb);
		sb.insert(10, "Murari");
		System.out.println(sb);
		sb.delete(10, 16);
		System.out.println(sb);
		sb.append("\n Hi I am Shahida");
		System.out.println(sb);
		
	}
}
