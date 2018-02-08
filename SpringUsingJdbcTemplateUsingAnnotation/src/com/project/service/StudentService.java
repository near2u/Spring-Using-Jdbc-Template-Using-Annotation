package com.project.service;

import java.util.List;

import com.project.model.Student;

public interface StudentService {

	public int save(Student student);
	public boolean updateStudent(Student student);
	public boolean deleteStudent(Student student);
	public Student findByID(int studentId);
	public Student findByName(int studentId);
	public List<Student> findAll();
	
}
