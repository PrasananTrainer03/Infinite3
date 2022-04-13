package com.java.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class WithdrawAccountMain {

	public static void main(String[] args) {
		Trans tran = new Trans();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo   ");
		tran.setAccountNo(sc.nextInt());
		System.out.println("Enter Withdraw Amount   ");
		tran.setTranAmount(sc.nextInt());
		BankDAO dao = new BankDAO();
		try {
			System.out.println(dao.withdrawAccount(tran));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
