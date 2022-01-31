package com.java.jsf;

import java.sql.SQLException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class Employ {

	private int empno;
	private String name;
	private Gender gender;
	private String dept;
	private String desig;
	private int basic;
    private Map<String,Object> sessionMap = 
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	static EmployDao dao;
	static {
		dao = new EmployDao();
	}
	public Employ[] showEmploy() throws ClassNotFoundException, SQLException {
		return dao.showEmploy();
	}
	
	public String delete(int empno) throws ClassNotFoundException, SQLException {
		dao.deleteEmploy(empno);
		return "/EmployShowAll.xhtml?faces-redirect=true";    
	}
	public String update(Employ employUpdated) throws ClassNotFoundException, SQLException {
		dao.updateEmploy(employUpdated);
		 return "/EmployShowAll.xhtml?faces-redirect=true";    
	}
	public String edit(int empno) throws ClassNotFoundException, SQLException {
		Employ employ = dao.searchEmploy(empno);
		 sessionMap.put("editEmploy", employ);
		return "/editemploy.xhtml?faces-redirect=true";
	}
	
	public String saveEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		dao.addEmploy(employ);
		 return "EmployShowAll.xhtml?faces-redirect=true";
	}
}
