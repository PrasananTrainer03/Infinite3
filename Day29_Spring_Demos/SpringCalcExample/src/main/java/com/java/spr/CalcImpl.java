package com.java.spr;

public class CalcImpl implements Calc {

	private int firstNo;
	private int secondNo;
	
	public int getFirstNo() {
		return firstNo;
	}
	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}
	public int getSecondNo() {
		return secondNo;
	}
	public void setSecondNo(int secondNo) {
		this.secondNo = secondNo;
	}
	@Override
	public int sum() {
		// TODO Auto-generated method stub
		return firstNo+secondNo;
	}
	@Override
	public int sub() {
		// TODO Auto-generated method stub
		return firstNo-secondNo;
	}
	@Override
	public int mult() {
		// TODO Auto-generated method stub
		return firstNo*secondNo;
	}
	
	
}
