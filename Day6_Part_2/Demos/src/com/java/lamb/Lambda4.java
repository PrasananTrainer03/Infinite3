package com.java.lamb;

import java.util.ArrayList;
import java.util.List;

public class Lambda4 {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Mohammad");
		names.add("Sai Harish");
		names.add("Shahida");
		names.add("Omkar");
		names.add("Abhishek");
		
		names.forEach(System.out::println);
	}
}
