package com.java.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.java.mvc.model.Employ;
import com.java.mvc.model.Gender;

public class EmployDaoImpl implements EmployDao {

	private JdbcTemplate jdbcTemplate;
	
	public EmployDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employ> showEmploy() {
		String cmd = "select * from Employ";
		List<Employ> listEmploy = jdbcTemplate.query(cmd, new RowMapper<Employ>() {
			 
	        @Override
	        public Employ mapRow(ResultSet rs, int rowNum) throws SQLException {
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
	 
	    return listEmploy;
	}

	@Override
	public Employ searchEmploy(int empno) {
		String sql = "select * from Employ where empno=?";
	    return jdbcTemplate.query(sql,new Object[] {empno}, new ResultSetExtractor<Employ>() {
	        public Employ extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Employ employ = new Employ();
		            employ.setEmpno(rs.getInt("empno"));
		            employ.setName(rs.getString("name"));
		            employ.setGender(Gender.valueOf(rs.getString("gender")));
		            employ.setDept(rs.getString("dept"));
		            employ.setDesig(rs.getString("desig"));
		            employ.setBasic(rs.getInt("basic"));
		            return employ;
	            }
	            return null;
	        }
	    });
	}

	@Override
	public void updateEmploy(Employ employ) {
		String cmd = "Update employ set name=?, Gender=?, Dept=?, Desig=?, "
				+ " Basic=? WHERE Empno=?";
		 jdbcTemplate.update(cmd, employ.getName(),
				 employ.getGender().toString(), 
				 employ.getDept(),employ.getDesig(),employ.getBasic(),
				 employ.getEmpno());
	}

	@Override
	public void deleteEmploy(int empno) {
		String sql = "DELETE FROM Employ WHERE empno=?";
	    jdbcTemplate.update(sql, empno);		
	}

}
