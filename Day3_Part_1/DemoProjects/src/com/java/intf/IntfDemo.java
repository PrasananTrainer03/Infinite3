package com.java.intf;

public class IntfDemo {

	public static void main(String[] args) {
		ITraining[] arr = new ITraining[] {
			new Arjun(),
			new Praveen(),
			new Sirisha()
		};
		
		for (ITraining iTraining : arr) {
			iTraining.name();
			iTraining.email();
		}
	}
}
