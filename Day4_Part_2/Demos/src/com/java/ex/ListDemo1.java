package com.java.ex;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	public static void main(String[] args) {
		List names = new ArrayList();
		names.add("Divyani");
		names.add("Kavyasri");
		names.add("Omkar");
		names.add("Pravin");
		names.add("Sarath");
		names.add("Jaison");
		System.out.println("Names are  ");
		for (Object ob : names) {
			System.out.println(ob);
		}
		
		names.add(3, "Kamesh");
		System.out.println("Names after adding new element  ");
		for (Object ob : names) {
			System.out.println(ob);
		}
		
		names.set(2, "Omkar Bhagat");
		System.out.println("Names after updating...");
		for(Object ob : names) {
			System.out.println(ob);
		}
		
		names.remove("Sarath");
		System.out.println("Names after removing object  ");
		for (Object object : names) {
			System.out.println(object);
		}
	}
}
