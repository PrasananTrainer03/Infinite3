package com.java.files;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInEx1 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("d:/files/cpy.txt");
			DataInputStream din = new DataInputStream(fin);
			int x = din.readInt();
			String name = din.readUTF();
			double y = din.readDouble();
			boolean flag = din.readBoolean();
			System.out.println("X value  " +x);
			System.out.println("Name is  " +name);
			System.out.println("Y value is  "+y);
			System.out.println("Boolean Value is  " +flag);
			din.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
