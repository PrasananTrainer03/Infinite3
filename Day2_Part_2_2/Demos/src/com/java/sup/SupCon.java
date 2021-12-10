package com.java.sup;

class Employ {
	int empno;
	String name;
	double basic;
	
	public Employ(int empno, String name, double basic) {
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Employ [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}
	
	
}

class Harish extends Employ {

	public Harish(int empno, String name, double basic) {
		super(empno, name, basic);
		// TODO Auto-generated constructor stub
	}
	
}

class Divyani extends Employ {

	public Divyani(int empno, String name, double basic) {
		super(empno, name, basic);
	}
	
}

class Dinesh extends Employ {

	public Dinesh(int empno, String name, double basic) {
		super(empno, name, basic);
		// TODO Auto-generated constructor stub
	}
	
}
public class SupCon {
	public static void main(String[] args) {
		Employ e1 = new Divyani(1, "Divyani", 94422);
		Employ e2 = new Dinesh(2, "Dinesh", 99234);
		Employ e3 = new Harish(3, "Harish", 99322);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}
}
