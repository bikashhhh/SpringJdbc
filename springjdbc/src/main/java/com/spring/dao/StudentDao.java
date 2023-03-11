package com.spring.dao;

import java.util.List;

import com.spring.entities.Student;

public interface StudentDao {
		public int insert(Student student);
		public int change(Student student); // to upadte values in table named "Student"
		public int delete(int studentId);
		public Student getStudent(int studentId);
		public List<Student> getAll();
		
}
