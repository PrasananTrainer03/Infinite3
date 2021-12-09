package com.java.demo;

public class CaseEx2 {

	public void show(String dayName) {
		switch(dayName) {
		case "Sun" : 
			System.out.println("Its Sunday...");
			break;
		case "Mon" : 
			System.out.println("Its Monday...");
			break;
		case "Tue" : 
			System.out.println("Its Tuesday...");
			break;
		case "Wed" :
			System.out.println("Its Wednesday...");
			break;
		case "Thu" : 
			System.out.println("Its Thursday...");
			break;
		case "Fri" : 
			System.out.println("Its Friday...");
			break;
		case "Sat" : 
			System.out.println("Its Saturday...");
			break;
		}
	}
	public static void main(String[] args) {
		String dayName="Mon";
		CaseEx2 obj = new CaseEx2();
		obj.show(dayName);
	}
}
