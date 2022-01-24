package com.java.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmploySearchMain {

	public static void main(String[] args) {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No   ");
		empno = sc.nextInt();
		SessionFactory sf = SessionHelper.getSession();
		Session session = sf.openSession();
		Query q = session.createQuery("from Employ where empno="+empno);
		List<Employ> employList = q.list();
		if (employList.size() ==1) {
			Employ employ = employList.get(0);
			System.out.println(employ);
		} else {
			System.out.println("*** Record Not Found ***");
		}
	}
}
