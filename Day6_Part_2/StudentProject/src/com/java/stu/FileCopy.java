package com.java.stu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		File src = new File("D:/java_infinite_3/Day5/StudentProject/src/com/java/stu/Student.java");
		File tar = new File("D:/files/Student.java");
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(tar);
			int ch;
			while((ch=fr.read()) != -1) {
				fw.write((char)ch);
			}
			fr.close();
			fw.close();
			System.out.println("*** File Copied Successfully ***");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
