package com.java.stu;

import java.util.List;
import java.util.Scanner;

public class StudentMain {

	static Scanner sc = new Scanner(System.in);
	
	static StudentBAL bal = new StudentBAL();
	
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("  O P T I O N S");
			System.out.println("  -------------");
			System.out.println("1. Add Student");
			System.out.println("2. Show Student");
			System.out.println("3. Search Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Update Student");
			System.out.println("6. Exit");
			System.out.println("Enter Your Choice   ");
			choice=sc.nextInt();
			switch(choice) {
			case 1 : 
				try {
					addStudent();
				} catch (StudentException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2 : 
				showStudent();
				break;
			case 3 : 
				searchStudent();
				break;
			case 4 : 
				deleteStudent();
				break;
			case 5 : 
				try {
					updateStudent();
				} catch (StudentException e) {
					e.printStackTrace();
				}
				break;
			}
			
		} while(choice!=6);
	}
	

	public static void deleteStudent() {
		int sno;
		System.out.println("Enter Student No    ");
		sno=sc.nextInt();
		String result = bal.deleteStudentBal(sno);
		System.out.println(result);
	}
	
	public static void searchStudent() {
		int sno;
		System.out.println("Enter Student No    ");
		sno=sc.nextInt();
		Student student = bal.searchStudentBal(sno);
		if (student!=null) {
			System.out.println(student);
		} else {
			System.out.println("Student Record Not Found...");
		}
	}
	
	public static void updateStudent() throws StudentException {
		Student student = new Student();
		System.out.println("Enter Student No   ");
		student.setSno(sc.nextInt());
		System.out.println("Enter Student Name   ");
		student.setName(sc.next());
		System.out.println("Enter City   ");
		student.setCity(sc.next());
		System.out.println("Enter Cgp   ");
		student.setCgp(sc.nextDouble());
		
		System.out.println(bal.updateStudentBal(student));
		
	}
	
	public static void addStudent() throws StudentException {
		Student student = new Student();
		System.out.println("Enter Student No   ");
		student.setSno(sc.nextInt());
		System.out.println("Enter Student Name   ");
		student.setName(sc.next());
		System.out.println("Enter City   ");
		student.setCity(sc.next());
		System.out.println("Enter Cgp   ");
		student.setCgp(sc.nextDouble());
		
		System.out.println(bal.addStudentBal(student));
		
	}
	
	public static void showStudent() {
		List<Student> studentList = bal.showStudentBal();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
}
