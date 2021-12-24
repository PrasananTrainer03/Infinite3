package com.java.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountMain {

	public static void main(String[] args) {
		int accountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo   ");
		accountNo = sc.nextInt();
		
		try {
			Bank bank = new BankDAO().searchAccount(accountNo);
			if (bank!=null) {
				System.out.println(bank);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
