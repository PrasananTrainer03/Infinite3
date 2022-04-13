package com.java.bank;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreateAccountMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO dao = new BankDAO();
		Bank bank = new Bank();
		System.out.println("Enter FirstName  ");
		bank.setFirstName(sc.next());
		System.out.println("Enter LastName  ");
		bank.setLastName(sc.next());
		System.out.println("Enter City  ");
		bank.setCity(sc.next());
		System.out.println("Enter State  ");
		bank.setState(sc.next());
		System.out.println("Enter Amount   ");
		bank.setAmount(sc.nextInt());
		System.out.println("CheqFacility   ");
		bank.setCheqFacil(sc.next());
		System.out.println("Enter Account Type  ");
		bank.setAccountType(sc.next());
		System.out.println("Enter Status   ");
		bank.setStatus(sc.next());
		System.out.println("Enter Date of OPen (yyyy-MM-dd)  ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt = sdf.parse(sc.next());
			java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
			bank.setDateOfOpen(sqlDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(dao.createAccount(bank));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
