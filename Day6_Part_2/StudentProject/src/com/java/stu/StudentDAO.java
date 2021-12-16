package com.java.stu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	static List<Student> studentList;
	
	static {
		studentList = new ArrayList<Student>();
	}
	
	public String udpateStudentDao(Student student) {
		Student studentFound = searchStudentDao(student.getSno());
		if (studentFound!=null) {
			studentFound.setName(student.getName());
			studentFound.setCity(student.getCity());
			studentFound.setCgp(student.getCgp());
			return "Student Record Updated...";
		}
		return "Student Record Not Found...";
	}
	
	public String deleteStudentDao(int sno) {
		Student studentFound = searchStudentDao(sno);
		if (studentFound!=null) {
			studentList.remove(studentFound);
			return "Student Record Deleted...";
		}
		return "Student Record Not Found...";
	}
	
	public Student searchStudentDao(int sno) {
		Student studentFound = null;
		for (Student student : studentList) {
			if (student.getSno()==sno) {
				studentFound = student;
			}
		}
		return studentFound;
	}
	public List<Student> showStudentDao() {
		return studentList;
	}
	
	public String readStudentFileDao() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("d:/files/student.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		studentList = (List<Student>)objin.readObject();
		return "Student Records are retrieved...";
	}
	public String writeStudentFileDao() throws IOException {
		FileOutputStream fout = new FileOutputStream("d:/files/student.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(studentList);
		objout.close();
		fout.close();
		return "Student Records Added Successfully...";
	}
	
	public String addStudentDao(Student student) {
		studentList.add(student);
		return "Student Record Added Successfully...";
	}
}
