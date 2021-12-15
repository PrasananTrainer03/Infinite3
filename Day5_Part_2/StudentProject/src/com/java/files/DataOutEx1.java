package com.java.files;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutEx1 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/files/cpy.txt");
			DataOutputStream dout = new DataOutputStream(fout);
			dout.writeInt(54);
			dout.writeUTF("Prasanna");
			dout.writeDouble(88852.44);
			dout.writeBoolean(true);
			dout.close();
			fout.close();
			System.out.println("*** File Created ***");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
