package com.java.ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateShow {

	public void show(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(dt));
	}
	public static void main(String[] args) {
		Date dt = new Date();
		DateShow obj = new DateShow();
		obj.show(dt);
	}
}
