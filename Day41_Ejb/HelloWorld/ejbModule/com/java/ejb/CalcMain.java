package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CalcMain {

	public static void main(String[] args) {
		CalcBeanRemote remote;
		
		try {
			remote = (CalcBeanRemote)new InitialContext().lookup("CalcBean/remote");
			int a,b,c;
			a=6;
			b=7;
			c=remote.sum(a, b);
			System.out.println("Sum is  " +c);
			c=remote.sub(a, b);
			System.out.println("Sub is  " +c);
			c=remote.mult(a, b);
			System.out.println("Mult is  " +c);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
