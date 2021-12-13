package com.java.ex;

public class ThrEx {

	public void show(int n) {
		if (n == 0) {
			throw new ArithmeticException("Zero is Invalid Value...");
		} else if (n < 0) {
			throw new NumberFormatException("Negative Nos Not Allowed...");
		} else {
			System.out.println("N value  " +n);
		}
	}
	public static void main(String[] args) {
		int n=4;
		ThrEx obj = new ThrEx();
		try {
			obj.show(n);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
