package com.java.spr;

public class CompanyImpl implements Company {

	private String companyName;
	private String branchName;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Override
	public String showCompany(String name) {
		// TODO Auto-generated method stub
		return name + " Working in " +companyName;
	}
	@Override
	public String showBranch(String name) {
		// TODO Auto-generated method stub
		return name + " Working branch " +branchName ;
	}
	
	
}
