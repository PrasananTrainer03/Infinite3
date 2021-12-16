package com.java.project;

public class Agent {
	
	private int agentId;
	private String name;
	private Gender gender;
	private String city;
	private int payMode;
	private double premium;

	
	
	public Agent() {
		// TODO Auto-generated constructor stub
	}


	public Agent(int agentId, String name, Gender gender, String city, int payMode, double premium) {
		this.agentId = agentId;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.payMode = payMode;
		this.premium = premium;
	}
	
	
}
