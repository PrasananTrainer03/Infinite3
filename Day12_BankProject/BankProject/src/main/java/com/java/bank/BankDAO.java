package com.java.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String withdrawAccount(int accountNo, int withdrawAmount) throws ClassNotFoundException, SQLException {
		Bank accountFound = searchAccount(accountNo);
		if (accountFound!=null) {
			connection = ConnectionHelper.getConnection();
			int balanceAmount = accountFound.getAmount();
			if (balanceAmount - withdrawAmount >= 1000) {
				String cmd = "update Bank set Amount=Amount-? where AccountNo=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setInt(2, withdrawAmount);
				pst.setString(3, "D");
				pst.executeUpdate();
				return "Amount Debited from Your Account...";
			} else {
				return "Insufficient Funds...";
			}
		}
		return "AccountNo Not Found...";
	}
	
	public String depositAccount(int accountNo, int depositAmount) throws ClassNotFoundException, SQLException {
		Bank accountFound = searchAccount(accountNo);
		if (accountFound !=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update Bank set Amount=Amount+? where AccountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, depositAmount);
			pst.setInt(2, accountNo);
			pst.executeUpdate();
			cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.setInt(2, depositAmount);
			pst.setString(3, "C");
			pst.executeUpdate();
			return "Amount Credited to Your Account...";
		}
		return "AccountNo Not Found...";
	}
	public String closeAccount(int accountNo) throws ClassNotFoundException, SQLException {
		Bank accountFound = searchAccount(accountNo);
		if (accountFound!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Bank Set Status='inactive' Where AccountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.executeUpdate();
			return "Account Closed...";
		}
		return "AccountNo Not Found...";
	}
	
	public Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Bank where AccountNo=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		Bank bank = null;
		
		if (rs.next()) {
			bank = new Bank();
			bank.setAccountNo(rs.getInt("accountNo"));
			bank.setFirstName(rs.getString("firstName"));
			bank.setLastName(rs.getString("lastName"));
			bank.setCity(rs.getString("city"));
			bank.setState(rs.getString("state"));
			bank.setAmount(rs.getInt("amount"));
			bank.setCheqFacil(rs.getString("cheqFacil"));
			bank.setAccountType(rs.getString("accountType"));
		}
		return bank;
	}
	
	public String createAccount(Bank bank) throws ClassNotFoundException, SQLException {
		int accno = generateAccountNo();
		bank.setAccountNo(accno);
		String cmd = "Insert into Bank(AccountNo,FirstName,LastName,City,State, "
				+ "Amount,CheqFacil,AccountType) values(?,?,?,?,?,?,?,?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accno);
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setInt(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		return "Account Created Successfully...";
	}
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		String cmd = "select case when max(accountNo) is NULL THEN 1   "
				+ " else Max(AccountNO)+1 END accno from Bank";
		connection= ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		return accno;
	}
}
