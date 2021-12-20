package com.java.testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployTest {

	@Test
	public void testGettersAndSetters() {
		Employ employ2 = new Employ();
		employ2.setEmpno(1);
		employ2.setName("Shahida");
		employ2.setGender(Gender.FEMALE);
		employ2.setDept("Java");
		employ2.setDesig("Programmer");
		employ2.setBasic(99442);
		
		assertEquals(1, employ2.getEmpno());
		assertEquals("Shahida", employ2.getName());
		assertEquals(Gender.FEMALE, employ2.getGender());
		assertEquals("Java", employ2.getDept());
		assertEquals("Programmer", employ2.getDesig());
		assertEquals(99442.0, employ2.getBasic(),0);
	}
	
	@Test
	public void testConstructor() {
		Employ employ1 = new Employ();
		assertNotNull(employ1);
		Employ employ2 = new Employ(1, "Omkar", Gender.MALE, "Java", "Programmer", 99542);
		assertEquals(1, employ2.getEmpno());
		assertEquals("Omkar", employ2.getName());
		assertEquals(Gender.MALE, employ2.getGender());
		assertEquals("Java", employ2.getDept());
		assertEquals("Programmer", employ2.getDesig());
		assertEquals(99542, employ2.getBasic(),0);
	}

	@Test
	public void testToString() {
		Employ employ2 = new Employ(1, "Omkar", Gender.MALE, "Java", "Programmer", 99542);
		String result = "Employ [empno=" + employ2.getEmpno() + ", name=" + employ2.getName()
								+ ", gender=" + employ2.getGender() + ", dept=" + employ2.getDept() + ", desig=" +
								 employ2.getDesig() + ", basic=" + employ2.getBasic() + "]";
		assertEquals(result, employ2.toString());
	}
}
