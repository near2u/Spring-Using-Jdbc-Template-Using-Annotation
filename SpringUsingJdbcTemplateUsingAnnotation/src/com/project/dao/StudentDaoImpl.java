package com.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public int save(Student student) {
		
		String sql = "insert into newstud values(0,?,?,?,?)";
		
		int update = jdbcTemplate.update(sql, new Object[]{student.getId(), student.getStudName(), student.getEmail(), student.getAddress()}); 
				
		System.out.println("Student Created......."+update);
		return update;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		
		String sql = "update newstud set stud_email=? where stud_id=?";
		jdbcTemplate.update(sql, student.getEmail(), student.getId());
		System.out.println("Student Updated.......");
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "delete from newstud where stud_id=?";
		int delete = jdbcTemplate.update(sql, student.getId());
		System.out.println("Student Deleted.......");
		return false;
	}

	@Override
	public Student findByID(int studentId) {
		// TODO Auto-generated method stub
		
		String sql = "select * from newstud where stud_id=?";
		Student stud = jdbcTemplate.queryForObject(sql, new StudentRowMapper(),studentId);
		//System.out.println(stud.getAddress());
		return stud;
	}

	@Override
	public Student findByName(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from newstud";
		 List<Student> list = jdbcTemplate.query(sql, new StudentRowMapper());
		
		
		return list;
	}

}
