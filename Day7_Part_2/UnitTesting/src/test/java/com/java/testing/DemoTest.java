package com.java.testing;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DemoTest {

	@Test
	public void testMinArray() {
		int[] a = new int[] {-1,66,2,4,33,66};
		assertEquals(-1, new Demo().minArray(a));
		int[] b = new int[] {77,66,2,-1,4,33,66};
		assertEquals(-1, new Demo().minArray(b));
	}
	
	@Test
	public void testMax3() {
		Demo obj = new Demo();
		assertEquals(5, obj.max3(5, 2, 3));
		assertEquals(5, obj.max3(2, 5, 3));
		assertEquals(5, obj.max3(2, 3, 5));
	}
	@Test
	public void testSum() {
		Demo obj = new Demo();
		assertEquals(5, obj.sum(2, 3));
	}
	@Test
	public void testSayHello() {
		Demo obj = new Demo();
		assertEquals("Welcome to Junit Programming...", obj.sayHello());
	}

}
