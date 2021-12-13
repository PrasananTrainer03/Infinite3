package com.java.abs;

public class AbsEx {
	public static void main(String[] args) {
		Training[] arr = new Training[] {
			new Divyani(),
			new Sekhar(),
			new Shahida()
		};
		
		for (Training training : arr) {
			training.name();
			training.email();
		}
	}
}
