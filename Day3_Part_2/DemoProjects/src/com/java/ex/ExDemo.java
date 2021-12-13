package com.java.ex;

public class ExDemo {
	public static void main(String[] args) {
		int[] a = new int[] {12,6};
		try {
			a[10]=5;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Size is Small...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
