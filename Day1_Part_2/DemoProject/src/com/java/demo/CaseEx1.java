package com.java.demo;

public class CaseEx1 {

	public void show(int n) {
		switch(n) {
		case 1 : 
			System.out.println("Hi I am Chandra sekhar...");
			break;
		case 2 : 
			System.out.println("Hi I am Basin Kumar...");
			break;
		case 3 : 
			System.out.println("Hi I am Dinesh...");
			break;
		case 4 : 
			System.out.println("Hi I am Swathi...");
			break;
		case 5 : 
			System.out.println("Hi I am Suchita...");
			break;
		default : 
			System.out.println("Invalid Choice...");
		}
	}
	public static void main(String[] args) {
		int n=1;
		CaseEx1 obj = new CaseEx1();
		obj.show(n);
	}
}
