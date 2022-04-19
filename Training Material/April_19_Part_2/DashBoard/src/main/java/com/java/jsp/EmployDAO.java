package com.java.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDAO {

	Connection con;
	PreparedStatement pst;
	
	public int generateEmployNo() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select case when max(empno) is null then 1 else "
				+ " max(empno)+1 end eno from Employ";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int eno = rs.getInt("eno");
		return eno;
	}
	public String deleteEmploy(int empno) throws ClassNotFoundException, SQLException {
		Employ employFound = searchEmploy(empno);
		if (employFound!=null) {
			con = ConnectionHelper.getConnection();
			String cmd = "Delete from Employ where empno=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return "Record Not Found...";
	}
	
	public String updateEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Update Employ set Name=?, Gender=?, Dept=?, Desig=?, Basic=? "
				+ " Where Empno=?";
		pst = con.prepareStatement(cmd);
		
		pst.setString(1, employ.getName());
		pst.setString(2, employ.getGender().toString());
		pst.setString(3, employ.getDept());
		pst.setString(4, employ.getDesig());
		pst.setDouble(5, employ.getBasic());
		pst.setInt(6, employ.getEmpno());
		pst.executeUpdate();
		return "Employ Record Inserted...";
	}
	public String addEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Insert into Employ(empno,name,gender,dept,desig,basic)  "
				+ " values(?,?,?,?,?,?)";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, employ.getEmpno());
		pst.setString(2, employ.getName());
		pst.setString(3, employ.getGender().toString());
		pst.setString(4, employ.getDept());
		pst.setString(5, employ.getDesig());
		pst.setDouble(6, employ.getBasic());
		pst.executeUpdate();
		return "Employ Record Inserted...";
	}
	public Employ searchEmploy(int empno) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Employ where empno=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employ employ = null;
		if (rs.next()) {
			employ = new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setGender(Gender.valueOf(rs.getString("gender")));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("basic"));
		}
		return employ;
	}
	
	public List<Employ> showEmploy() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Employ";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employ> employList = new ArrayList<Employ>();
		Employ employ = null;
		while(rs.next()) {
			employ = new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setGender(Gender.valueOf(rs.getString("gender")));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("basic"));
			employList.add(employ);
		}
		return employList;
	}
}
