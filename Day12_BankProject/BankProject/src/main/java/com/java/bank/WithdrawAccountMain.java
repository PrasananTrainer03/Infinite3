package com.java.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class WithdrawAccountMain {

	public static void main(String[] args) {
		int accountNo, withdrawAccount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo    ");
		accountNo = sc.nextInt();
		System.out.println("Enter Withdraw Account   ");
		withdrawAccount = sc.nextInt();
		try {
			System.out.println(new BankDAO().withdrawAccount(accountNo, withdrawAccount));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
