package com.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

class Thr3 implements Runnable {

	@Override
	public void run() {
		Vector<String> names = new Vector<String>();
		names.add("Dinesh");
		names.add("Shekhar");
		names.add("Jaison");
		names.add("Omkar");
		names.add("Shankar");
		names.add("Sunil");
		names.add("Kamesh");

		for (String s : names) {
			System.out.println("Vector  " +s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Thr2 implements Runnable {

	@Override
	public void run() {
		SortedSet<String> names = new TreeSet<String>();
		names.add("Dinesh");
		names.add("Shekhar");
		names.add("Jaison");
		names.add("Omkar");
		names.add("Shankar");
		names.add("Sunil");
		names.add("Kamesh");

		for (String s : names) {
			System.out.println("Sorted Data  " +s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Thr1 implements Runnable {
	@Override
	public void run() {
		List<String> names = new ArrayList<String>();
		names.add("Dinesh");
		names.add("Shekhar");
		names.add("Jaison");
		names.add("Shankar");
		names.add("Omkar");
		names.add("Sunil");
		names.add("Kamesh");
		for (String s : names) {
			System.out.println("ArrayList " +s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thr1());
		Thread t2 = new Thread(new Thr2());
		Thread t3 = new Thread(new Thr3());
		
		t1.start();
		t2.start();
		t3.start();
	}
}
