package com.java.testing;

public class Demo {

	public int minArray(int a[]) {
		int min=a[0];
		for(int i=0;i<a.length;i++) {
			if (min > a[i]) {
				min=a[i];
			}
		}
		return min;
	}
	public int max3(int a, int b, int c) {
		int m=a;
		if (m < b) {
			m=b;
		}
		if (m < c) {
			m=c;
		}
		return m;
	}
	public String sayHello() {
		return "Welcome to Junit Programming...";
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
}
