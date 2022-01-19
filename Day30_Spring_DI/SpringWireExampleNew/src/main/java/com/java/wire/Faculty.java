package com.java.wire;

import java.util.List;

public class Faculty {

	private String fname;
	private List<Student> students;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void showAllInfo() {
		System.out.println("Faculty Name  " +fname + " Sharing lunch with students");
		for (Student student : students) {
			student.showStudent();
		}
	}
	
	
}
