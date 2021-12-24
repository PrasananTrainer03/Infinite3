package com.java.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class CloseAccountMain {

	public static void main(String[] args) {
		int accountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo   ");
		accountNo = sc.nextInt();
		try {
			System.out.println(new BankDAO().closeAccount(accountNo));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
