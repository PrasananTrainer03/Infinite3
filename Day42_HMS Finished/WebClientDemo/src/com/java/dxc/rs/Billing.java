package com.java.dxc.rs;

public class Billing {

	private String bookid;
	private String roomid;
	private int noofdays;
	private int billamt;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public int getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}
	public int getBillamt() {
		return billamt;
	}
	public void setBillamt(int billamt) {
		this.billamt = billamt;
	}
	
}
