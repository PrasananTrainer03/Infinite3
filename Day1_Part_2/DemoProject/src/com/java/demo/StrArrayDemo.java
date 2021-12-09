package com.java.demo;

public class StrArrayDemo {

	public void show() {
		String[] names = new String[] {
			"Chandra","Dinesh","Divyani","Praveen","Madhu","Shahida"
		};
		System.out.println("Names are  ");
		for (String s : names) {
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		StrArrayDemo obj = new StrArrayDemo();
		obj.show();
	}
}
