package com.spring.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.entities.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stub
		//insert query --->Always keep your dB operations in dao
        String query= "insert into Student(id,name,city) values (?,?,?)";
        int r = this.template.update(query,student.getId(),student.getName(), student.getCity());
		return r;
	}

	public int change(Student student) {
		// update db
		String query= "update Student set name =? , city=? where id =?";
		int r=this.template.update(query,student.getName(),student.getCity(),student.getId());
		
		return r;
	}

	public int delete(int studentId) {
		// delete row from a table 
		String query= "delete from Student where id=?";
		int r= this.template.update(query,studentId);
		return r;
	}

	public Student getStudent(int studentId) {
		//select query chalao
		String query= " select * from student where id=?";
		RowMapper<Student> rowMapper= new RowMapperImpl(); // Parent class reference can hold child class object
		Student student = this.template.queryForObject(query, rowMapper, studentId); // pick Student pbject
		return student; // return student object
	
	}

	public List<Student> getAll() {
		// select multiple rows or objects
		String query= "select * from Student";
		List<Student> student = this.template.query(query, new RowMapperImpl());
		return student;
	}
	

	
	
}
