package com.java.demo;

public class StaticExample {

	static int score;
	
	public void incr() {
		score++;
	}
	
	public void show() {
		System.out.println(score);
	}
	
	public static void main(String[] args) {
		StaticExample obj1 = new StaticExample();
		StaticExample obj2 = new StaticExample();
		StaticExample obj3 = new StaticExample();
		obj1.incr();
		obj2.incr();
		obj3.incr();
		obj1.show();
	}
}
