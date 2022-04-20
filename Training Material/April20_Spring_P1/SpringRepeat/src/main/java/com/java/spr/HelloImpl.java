package com.java.spr;

public class HelloImpl implements Hello {

	private String greetingMessage;
	private String closingMessage;
	
	
	public String getGreetingMessage() {
		return greetingMessage;
	}

	public void setGreetingMessage(String greetingMessage) {
		this.greetingMessage = greetingMessage;
	}

	public String getClosingMessage() {
		return closingMessage;
	}

	public void setClosingMessage(String closingMessage) {
		this.closingMessage = closingMessage;
	}

	@Override
	public String salution(String user) {
		// TODO Auto-generated method stub
		return greetingMessage+user;
	}

	@Override
	public String resolve(String user) {
		// TODO Auto-generated method stub
		return closingMessage+user;
	}

}
