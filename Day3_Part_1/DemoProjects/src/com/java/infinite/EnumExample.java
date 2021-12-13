package com.java.infinite;

public class EnumExample {

	public static void main(String[] args) {
		WeekDay wd = WeekDay.MONDAY;
		System.out.println("Week Day is  " +wd);
		
		// How to Convert String to Enum 
		
		String str="FRIDAY";
		WeekDay wd2 = WeekDay.valueOf(str);
		System.out.println(wd2);
	}
}
