package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.project.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		//System.out.println("ID:.."+rs.getString(2));
		student.setId(rs.getInt(2));
		student.setStudName(rs.getString(3));
		student.setEmail(rs.getString(4));
		student.setAddress(rs.getString(5));
		
		
		return student;
	}


}
