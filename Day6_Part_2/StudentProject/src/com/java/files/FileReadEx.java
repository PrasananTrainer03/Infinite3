package com.java.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadEx {
	public static void main(String[] args) {
		File file1 = new File("D:/java_infinite_3/Day5/StudentProject/src/com/java/stu/Student.java");
		try {
			FileReader fr = new FileReader(file1);
			int ch;
			while((ch=fr.read()) != -1) {
				System.out.print((char)ch);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
