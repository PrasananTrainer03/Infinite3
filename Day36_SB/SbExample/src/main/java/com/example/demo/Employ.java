package com.example.demo;

public class Employ {

	private int empno;
	private String name;
	private int basic;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	
	public Employ(int empno, String name, int basic) {
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}
	
	public Employ() {

	}
	
	
}
