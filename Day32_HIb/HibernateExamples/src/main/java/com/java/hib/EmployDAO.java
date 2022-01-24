package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployDAO {

	SessionFactory sf;
	Session session;
	public List<Employ> showEmploy() {
		SessionFactory sf = SessionHelper.getSession();
		Session session =sf.openSession();
		Query q = session.createQuery("from Employ");
		List<Employ> employList = q.list();
		return employList;
	}
	
	public String addEmploy(Employ employ) {
		SessionFactory sf = SessionHelper.getSession();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(employ);
		t.commit();
		return "Record Inserted...";
	}
	
	public String deleteEmploy(int empno) {
		SessionFactory sf = SessionHelper.getSession();
		Session s = sf.openSession();
		Employ employ = searchEmploy(empno);
		s.close();
		s= sf.openSession();
		Transaction t = s.beginTransaction();
		s.delete(employ);
		t.commit();
		return "Record Deleted...";
	}
	
	public String update(Employ employ) {
		SessionFactory sf = SessionHelper.getSession();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(employ);
		t.commit();
		return "Record Updated...";
	}
	
	public Employ searchEmploy(int empno) {
		SessionFactory sf = SessionHelper.getSession();
		Session session = sf.openSession();
		Query q = session.createQuery("from Employ where empno="+empno);
		List<Employ> employList = q.list();
		Employ employ = null;
		if (employList.size() ==1) {
			employ = employList.get(0);
		}
		return employ;
	}
}
