package com.java.ex;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortDemo {

	public static void main(String[] args) {
		SortedSet names = new TreeSet();
		names.add("Rohit");
		names.add("Abhishek");
		names.add("Sekhar");
		names.add("Dinesh");
		names.add("Kavyasri");
		names.add("Sirisha");
		System.out.println("Names are  ");
		for (Object ob : names) {
			System.out.println(ob);
		}
	}
}
