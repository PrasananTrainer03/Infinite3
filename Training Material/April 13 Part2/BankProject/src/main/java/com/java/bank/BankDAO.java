package com.java.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO {

	Connection con;
	PreparedStatement pst;
	
	public String withdrawAccount(Trans tran) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		Bank bank = searchAccount(tran.getAccountNo());
		int amount = bank.getAmount();
		if (amount-tran.getTranAmount() >= 1000) {
			String cmd = "Update Bank set Amount=Amount-? where AccountNo=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, tran.getTranAmount());
			pst.setInt(2, tran.getAccountNo());
			pst.executeUpdate();
			cmd = "Insert into Trans(AccountNO,TransAmount,TransType) values(?,?,?)";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, tran.getAccountNo());
			pst.setInt(2, tran.getTranAmount());
			pst.setString(3, "D");
			pst.executeUpdate();
			return "Amount Debited...";
		}
		return "Insufficient Funds...";
	}
	
	public String depositAccount(Trans tran) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Update Bank set Amount=Amount+? where AccountNo=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, tran.getTranAmount());
		pst.setInt(2, tran.getAccountNo());
		pst.executeUpdate();
		cmd = "Insert into Trans(AccountNO,TransAmount,TransType) values(?,?,?)";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, tran.getAccountNo());
		pst.setInt(2, tran.getTranAmount());
		pst.setString(3, "C");
		pst.executeUpdate();
		return "Amount Credited...";
	}
	public Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		pst = con.prepareStatement("select * from Bank where AccountNo=?");
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		Bank bank= null;
		if(rs.next()) {
			bank = new Bank();
			bank.setAccountNo(rs.getInt("accountNo"));
			bank.setFirstName(rs.getString("FirstName"));
			bank.setLastName(rs.getString("lastName"));
			bank.setCity(rs.getString("city"));
			bank.setState(rs.getString("state"));
			bank.setAmount(rs.getInt("amount"));
			bank.setCheqFacil(rs.getString("cheqFacil"));
			bank.setAccountType(rs.getString("accountType"));
			bank.setStatus(rs.getString("status"));
			bank.setDateOfOpen(rs.getDate("dateOfOpen"));
		}
		return bank;
	}
	public String createAccount(Bank bank) throws ClassNotFoundException, SQLException {
		int accno = generateAccountNo();
		bank.setAccountNo(accno);
		String cmd = "Insert into Bank(AccountNo,FirstName,LastName,City,State, "
				+ "Amount,CheqFacil,AccountType,status,dateOfOpen) values(?,?,?,?,?,?,?,?,?,?)";
		con = ConnectionHelper.getConnection();
		pst = con.prepareStatement(cmd);
		pst.setInt(1, accno);
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setInt(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.setString(9, bank.getStatus());
		pst.setDate(10, bank.getDateOfOpen());
		pst.executeUpdate();
		return "Account Created Successfully...";
	}
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select case when max(accountNo) IS NULL then 1  "
				+ " else max(accountNo)+1 end accno from Bank";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno=rs.getInt("accno");
		return accno;
	}
}
