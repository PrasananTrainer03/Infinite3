package com.java.gen;

import java.util.ArrayList;
import java.util.List;

public class GenList {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Divyani");
		names.add("Shahida");
		names.add("Kavya");
		names.add("Rajesh");
		for (String s : names) {
			System.out.println(s);
		}
	}
}
