package com.java.files;

import java.io.File;

public class FileInfo {

	public static void main(String[] args) {
		File file1 = new File("D:/java_infinite_3/Day5/StudentProject/src/com/java/stu/Student.java");
		System.out.println("File Name  " +file1.getName());
		System.out.println("Full Name   " +file1.getPath());
		System.out.println("Parent Directory  " +file1.getParent());
	}
}
