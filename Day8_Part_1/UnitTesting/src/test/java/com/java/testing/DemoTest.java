package com.java.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoTest {

	static Demo obj;
	@BeforeClass
	public static void setUp() {
		obj = new Demo();
	}
	
	@Before
	public void showInfo() {
		System.out.println("Test Case Started...");
	}
	
	@After
	public void endNotes() {
		System.out.println("Test Case Ended...");
	}
	
	@AfterClass
	public static void cleanUp() {
		obj = null;
	}
	
	@Test
	public void testMapp() {
		//Demo obj = new Demo();
		assertNull(obj.getProperty("Omkar"));
		assertNotNull(obj.getProperty("Bhargav"));
	}
	
	@Test 
	public void testEvenOdd() {
		//Demo obj = new Demo();
		assertTrue(obj.evenOdd(4));
		assertFalse(obj.evenOdd(5));
	}
	@Test
	public void testMinArray() {
	//	Demo obj = new Demo();
		int[] a = new int[] {-1,66,2,4,33,66};
		assertEquals(-1, new Demo().minArray(a));
		int[] b = new int[] {77,66,2,-1,4,33,66};
		assertEquals(-1, obj.minArray(b));
	}
	
	@Test
	public void testMax3() {
	//	Demo obj = new Demo();
		assertEquals(5, obj.max3(5, 2, 3));
		assertEquals(5, obj.max3(2, 5, 3));
		assertEquals(5, obj.max3(2, 3, 5));
	}
	@Test
	public void testSum() {
	//	Demo obj = new Demo();
		assertEquals(5, obj.sum(2, 3));
	}
	@Test
	public void testSayHello() {
	//	Demo obj = new Demo();
		assertEquals("Welcome to Junit Programming...", obj.sayHello());
	}

}
