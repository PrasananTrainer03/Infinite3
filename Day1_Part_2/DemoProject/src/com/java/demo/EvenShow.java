package com.java.demo;

public class EvenShow {

	public void show(int n) {
		for(int i=0;i<=n;i+=2) {
			System.out.println("Even  " +i);
		}
	}
	public static void main(String[] args) {
		int n=20;
		EvenShow obj = new EvenShow();
		obj.show(n);
	}
}
