package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDao;
import com.spring.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	  public static void main(String [] args) {
		  System.out.println("Program started.....");
		  ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
          //JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
           //insert query
         // String query= "insert into Student(id,name,city) values (?,?,?)";
          //fire query
         // int result= template.update(query,226, "Shiva Shankara", "kailash");
		  
		  StudentDao studentDao= context.getBean("studentdao",StudentDao.class);
		  
		/* Statements to insert values in db
		 * Student student = new Student(); student.setId(667);
		 * student.setCity("Tokyo 2"); student.setName("Munna Bhai Mbbs");
		 * 
		 * int result= studentDao.insert(student);
		 */ 
		  
		  
		/* TO update row in a table 
		 * Student student=new Student(); student.setId(667);
		 * student.setName("Raja Ji"); student.setCity("Banaras");
		 */
		  
		/*  Student student =new Student();
		  student.setId(2);
		  
		  studentDao.delete(student.getId());
		  
		 int result = studentDao.change(student);
		  System.out.println("Number of Students rows deleted : " + result);
		  */
		  
		 /* Get single row
		  *  Student student = studentDao.getStudent(666);
		  *   System.out.println(student);
		  */
		  
		 List<Student> student = studentDao.getAll();
		 for(Student s: student) {
			 System.out.println(s);
		 } 		
	  }
}
