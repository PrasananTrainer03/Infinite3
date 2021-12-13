package com.java.abs1;

public class AbsTest {

	public static void main(String[] args) {
		Flight[] arr = new Flight[] {
			new Chandra(),
			new Omkar(),
			new Swathi()
		};
		
		for (Flight flight : arr) {
			flight.idProof();
			flight.ticket();
		}
	}
}
