package com.java.ex;

public class Division {
	public static void main(String[] args) {
		int a,b,c;
		try {
			a=Integer.parseInt(args[0]);
			b=Integer.parseInt(args[1]);
			c=a/b;
			System.out.println("Division Value is   " +c);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Arguments are not passed...");
		} catch (NumberFormatException e) {
			System.out.println("String Cannot be converted as Integer...");
		} catch (ArithmeticException e) {
			System.out.println("Zero by division impossible...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Program From Infinite Training...");
		}
	}
}
