package com.java.ex;

public class Calculation {

	public void show(int a, int b) throws NegativeException, NumberZeroException {
		if (a < 0 || b < 0) {
			throw new NegativeException("Negative Nos Not Allowed...");
		} else if (a == 0 || b == 0) {
			throw new NumberZeroException("Zero is Invalid Value...");
		} else {
			int c=a+b;
			System.out.println("Sum is   " +c);
		}
	}
	
	public static void main(String[] args) {
		int a,b;
		a=5;
		b=0;
		Calculation obj = new Calculation();
		try {
			obj.show(a, b);
		} catch (NegativeException | NumberZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
