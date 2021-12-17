package com.java.threads;

class Data {
 	synchronized void showMsg(String name) {
		System.out.print("Hello  " +name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" How are You...");
	}
}

class Gowri extends Thread {
	Data d; 
	Gowri(Data d) {
		this.d=d;
	}
	@Override
	public void run() {
		d.showMsg("Shankar");
	}
}

class Omkar extends Thread {
	Data d;
	
	Omkar(Data d) {
		this.d=d;
	}
	
	@Override
	public void run() {
		d.showMsg("Omkar");
	}
}

class Divyani extends Thread {
	Data d;
	
	Divyani(Data d) {
		this.d=d;
	}
	
	@Override
	public void run() {
		d.showMsg("Divyani");
	}
}


public class SyncDemo {
	public static void main(String[] args) {
		Data d = new Data();
		Divyani obj1 = new Divyani(d);
		Omkar obj2 = new Omkar(d);
		Gowri obj3 = new Gowri(d);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		Thread t3 = new Thread(obj3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
