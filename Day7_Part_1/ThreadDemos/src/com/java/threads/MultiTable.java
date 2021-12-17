package com.java.threads;

class TableExample {
	void showTab(int n) {
		for(int i=1;i<=10;i++) {
			int p=n*i;
			System.out.println(n + "  *  " +i+ "  =  " +p);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Tab3 implements Runnable {

	TableExample tb1;
	
	Tab3(TableExample tb1) {
		this.tb1=tb1;
	}
	@Override
	public void run() {
		tb1.showTab(18);
	}
	
}


class Tab2 implements Runnable {

	TableExample tb1;
	
	Tab2(TableExample tb1) {
		this.tb1=tb1;
	}
	@Override
	public void run() {
		tb1.showTab(17);
	}
	
}


class Tab1 implements Runnable {

	TableExample tb1;
	
	Tab1(TableExample tb1) {
		this.tb1=tb1;
	}
	@Override
	public void run() {
		tb1.showTab(12);
	}
	
}

public class MultiTable {
	public static void main(String[] args) {
		TableExample obj1 = new TableExample();
		Tab1 tab1 = new Tab1(obj1);
		Tab2 tab2 = new Tab2(obj1);
		Tab3 tab3 = new Tab3(obj1);
		
		Thread t1 = new Thread(tab1);
		Thread t2 = new Thread(tab2);
		Thread t3 = new Thread(tab3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
