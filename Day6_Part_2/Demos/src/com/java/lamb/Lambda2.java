package com.java.lamb;

interface ICalc {
	int calc(int a, int b);
}
public class Lambda2 {

	public static void main(String[] args) {
		ICalc obj1 = (a,b) -> {
			return a+b;
		};
		
		ICalc obj2 = (a,b) -> {
			return a-b;
		};
		
		ICalc obj3 = (a,b) -> {
			return a*b;
		};
		
		System.out.println("Sum is  " +obj1.calc(12, 5));
		System.out.println("Sub is  " +obj2.calc(12, 5));
		System.out.println("Mult is  " +obj3.calc(12, 5));
	}
}
