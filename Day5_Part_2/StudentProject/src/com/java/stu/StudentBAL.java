package com.java.stu;

import java.util.List;

public class StudentBAL {

	static StringBuilder sb = new StringBuilder();
	public boolean validateStudent(Student student) {
		boolean isValid = true;
		
		if (student.getSno() <= 0) {
			isValid = false;
			sb.append("Student No Cannot be Zero or Negative...\n");
		}
		
		if (student.getName().length() < 5) {
			isValid=false;
			sb.append("Name Contains Min. 5 characters...\n");
		}
		
		if (student.getCity().length() < 3) {
			isValid=false;
			sb.append("City Contains Min. 3 characters...\n");
		}
		
		if (student.getCgp() <= 0) {
			isValid=false;
			sb.append("CGP Cannot be Negative or ZERO...\n");
		}
		return isValid;
	}
	
	public String deleteStudentBal(int sno) {
		return new StudentDAO().deleteStudentDao(sno);
	}
	
	public Student searchStudentBal(int sno) {
		return new StudentDAO().searchStudentDao(sno);
	}
	public List<Student> showStudentBal() {
		return new StudentDAO().showStudentDao();
	}
	
	public String updateStudentBal(Student student) throws StudentException {
		StudentDAO dao = new StudentDAO();
		if (validateStudent(student)==true) {
			return dao.udpateStudentDao(student);
		} else {
			throw new StudentException(sb.toString());
		}
	}
	
	public String addStudentBal(Student student) throws StudentException {
		StudentDAO dao = new StudentDAO();
		if (validateStudent(student)==true) {
			return dao.addStudentDao(student);
		} else {
			throw new StudentException(sb.toString());
		}
	}
}
