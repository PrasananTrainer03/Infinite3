package com.java.demo;

public class EmployShow {

	public static void main(String[] args) {
		Employ employ = new Employ();
		employ.setEmpno(1);
		employ.setName("Kamesh");
		employ.setBasic(99944);
		
		System.out.println("Employ No   " +employ.getEmpno());
		System.out.println("Employ Name  " +employ.getName());
		System.out.println("Basic   " +employ.getBasic());
	}
}
