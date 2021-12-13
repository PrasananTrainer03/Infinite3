package com.java.ex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExampleNew {

	public void show(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(str);
		System.out.println(dt);
	}
	public static void main(String[] args) {
		String str="2021-12-13";
		DateExampleNew obj = new DateExampleNew();
		try {
			obj.show(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
