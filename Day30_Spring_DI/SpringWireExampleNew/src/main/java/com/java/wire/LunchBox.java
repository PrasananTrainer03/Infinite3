package com.java.wire;

public class LunchBox {

	private String snacks;

	public String getSnacks() {
		return snacks;
	}

	public void setSnacks(String snacks) {
		this.snacks = snacks;
	}

	@Override
	public String toString() {
		return "LunchBox [snacks=" + snacks + "]";
	}

	
}
