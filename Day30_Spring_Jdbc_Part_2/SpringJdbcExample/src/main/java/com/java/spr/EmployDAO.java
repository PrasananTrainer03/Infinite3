package com.java.spr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String deleteEmploy(int empno) {
		Employ employFound = searchEmploy(empno);
		if (employFound!=null) {
			String cmd = "Delete From Employ where empno=?";
			jdbcTemplate.update(cmd, new Object[] {empno});
			return "Record Deleted...";
		}
		return "Record Not Found...";
	}
	
	public String updateEmploy(Employ employ) {
		Employ employFound = searchEmploy(employ.getEmpno());
		if (employFound !=null) {
		String cmd = "Update Employ Set Name=?, Gender=?, Dept=?, Desig=?, Basic=? where Empno=?";
		jdbcTemplate.update(cmd, new Object[] {employ.getName(), 
				employ.getGender().toString(), employ.getDept(), employ.getDesig(), employ.getBasic(), 
				employ.getEmpno()
			});
		return "Record Updated...";
		}
		return "Record NOt Found...";
	}
	
	public String addEmploy(Employ employ) {
		String cmd = "Insert into Employ(empno,name,gender,dept,desig,basic) "
				+ " values(?,?,?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {employ.getEmpno(), employ.getName(), 
				employ.getGender().toString(),employ.getDept(),employ.getDesig(),employ.getBasic()
			});
		return "Record Inserted...";
	}
	public Employ searchEmploy(int empno) {
		String cmd = "select * from Employ where empno=?";
		List<Employ> employList = jdbcTemplate.query(cmd, new Object[] {empno}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employ employ = new Employ();
				employ.setEmpno(rs.getInt("empno"));
				employ.setName(rs.getString("name"));
				employ.setGender(Gender.valueOf(rs.getString("gender")));
				employ.setDept(rs.getString("dept"));
				employ.setDesig(rs.getString("desig"));
				employ.setBasic(rs.getInt("basic"));
				return employ;
			}
		});
		if (employList.size()==1) {
			return employList.get(0);
		}
		return null;
	}
	
	public List<Employ> showEmploy() {
		String cmd = "select * from Employ";
		List<Employ> employList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employ employ = new Employ();
				employ.setEmpno(rs.getInt("empno"));
				employ.setName(rs.getString("name"));
				employ.setGender(Gender.valueOf(rs.getString("gender")));
				employ.setDept(rs.getString("dept"));
				employ.setDesig(rs.getString("desig"));
				employ.setBasic(rs.getInt("basic"));
				return employ;
			}
			
		});
		return employList;
	}
}
