package com.java.ex;

public class VotingException extends Exception {

	VotingException() { }
	
	VotingException(String error) {
		super(error);
	}
}
