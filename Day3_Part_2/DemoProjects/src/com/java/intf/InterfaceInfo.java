package com.java.intf;

class Demo implements IOne, ITwo {

	@Override
	public void trainer() {
		System.out.println("Trainer is Prasanna...");
	}

	@Override
	public void topic() {
		System.out.println("Topic is Java Training...");
	}
	
}
public class InterfaceInfo {
	public static void main(String[] args) {
		Demo obj = new Demo();
		obj.topic();
		obj.trainer();
	}
}
