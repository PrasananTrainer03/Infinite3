package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EmployBeanRemote {

	public boolean addEmployee(Employ employee);
	Employ[] showEmploy();
}
