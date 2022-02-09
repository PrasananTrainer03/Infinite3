package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowEmploy {

	public static void main(String[] args) {
		EmployBeanRemote service;
		try {
			service = (EmployBeanRemote)new InitialContext().lookup("EmployBean/remote");
			System.out.println(service.showEmploy().length);
			for (Employ employ : service.showEmploy()) {
				System.out.println("Employ No  " +employ.getEmpno());
				System.out.println("Employ Name  " +employ.getName());
				System.out.println("Gender  " +employ.getGender());
				System.out.println("Department  " +employ.getDept());
				System.out.println("Designation  " +employ.getDesig());
				System.out.println("Basic   " +employ.getBasic());
				System.out.println("--------------------------------------------------");
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
