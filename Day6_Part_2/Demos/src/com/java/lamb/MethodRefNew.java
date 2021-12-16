package com.java.lamb;

interface ITest {
	int calc(int a, int b);
}

public class MethodRefNew {

	public static int sum(int x, int y) {
		return x+y;
	}
	
	public static int sub(int x, int y) {
		return x-y;
	}
	
	public static int mult(int x, int y) {
		return x*y;
	}
	
	public static void main(String[] args) {
		
		ITest obj1 = MethodRefNew::sum;
		System.out.println("Sum is  " +obj1.calc(12, 5));
		
		ITest obj2 = MethodRefNew::sub;
		System.out.println("Sub is  " +obj2.calc(12, 5));
		
		ITest obj3 = MethodRefNew::mult;
		System.out.println("Mult is  " +obj3.calc(12, 5));
	}
}
