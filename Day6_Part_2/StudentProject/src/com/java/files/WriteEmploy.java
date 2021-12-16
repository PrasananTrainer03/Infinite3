package com.java.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteEmploy {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/files/Employ.txt");
			ObjectOutputStream objout = new ObjectOutputStream(fout);
			Employ employ = new Employ(1, "Kamesh", 99424);
			objout.writeObject(employ);
			objout.close();
			fout.close();
			System.out.println("Employ Object Stored...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
