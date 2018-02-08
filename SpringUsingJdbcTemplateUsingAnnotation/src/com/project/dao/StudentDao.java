package com.project.dao;

import java.util.List;

import com.project.model.Student;

public interface StudentDao {
	
	public int save(Student student);
	public boolean updateStudent(Student student);
	public boolean deleteStudent(Student student);
	public Student findByID(int studentId);
	public Student findByName(int studentId);
	public List<Student> findAll();

}
