package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface EmployeeRemote {
	public boolean addEmployee(Employ employee);
	List<Employ> showEmploy();

}
