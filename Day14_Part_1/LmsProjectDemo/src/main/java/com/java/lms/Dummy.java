package com.java.lms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dummy {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("2022-01-05");
		Date d2 = sdf.parse("2022-01-13");
		List data = new LeaveDetailsDAO().getDatesBetweenUsingJava7(d1, d2);
		List<String> dates = new ArrayList<String>();
		int weekDays = 0;
		String s="";
		for (Object object : data) {
			System.out.println(object);
			dates.add(object.toString());
		}
		System.out.println(dates.size());
		for (String str : dates) {
			if (str.contains("Sat") || str.contains("Sun")) {
				weekDays++;
			System.out.println(str);
			}
		}
		System.out.println("WeekDays are  " +weekDays);
	}
}
