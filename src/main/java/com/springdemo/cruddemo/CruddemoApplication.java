package com.springdemo.cruddemo;

import java.util.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springdemo.cruddemo.DAO.StudentDAOImpl;
import com.springdemo.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	// CommandLineRunner is a spring boot method. It is called after the spring beans are up.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAOImpl studentDAO) {
		return runner->{
			//createStudent(studentDAO);
			
			//createMultipleStudents(studentDAO);
			
			//readStudent(studentDAO);
			
			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			
			deleteStudent(studentDAO);
		};
	}
	
	private void deleteStudent(StudentDAOImpl studentDAO) {
		// TODO Auto-generated method stub
		int studentId = 4; 
		System.out.println("Deleting student id: "+ studentId);
		
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAOImpl studentDAO) {
		// TODO Auto-generated method stub
		// Get the student ID. 
		int studentId = 1;
		System.out.println("Retrieving Student...");
		Student tempStudent = studentDAO.findById(studentId);
				
		// Update the last name 
		System.out.println("Updating the student...");
		tempStudent.setFirstName("Scooby");
		
		// Call the update function.
		studentDAO.update(tempStudent);
	}

	private void queryForStudentsByLastName(StudentDAOImpl studentDAO) {
		// TODO Auto-generated method stub
		List<Student> theStudents = studentDAO.findByLastName("Don");
		
		// display list of student
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAOImpl studentDAO) {
		// TODO Auto-generated method stub
		// Get a list of students 
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAOImpl studentDAO) {
		// TODO Auto-generated method stub
		// Create Student object
		System.out.println("Creating the student ...");
		Student tempStudent1 = new Student("John", "Don", "johnD.spring@udemy.com" );
		
		System.out.println("Saving the student ...");
		// Save the student 
		studentDAO.save(tempStudent1);
		
		// Display the id		
		int tempId = tempStudent1.getId();
		System.out.println("Display the student id "+tempId);
		
		// retrieve the student
		System.out.println("Read the data from the student");
		Student myStudent = studentDAO.findById(tempId);
		
		// Display the student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAOImpl studentDAO) {
		// TODO Auto-generated method stub
		// Create student object 
		System.out.println("Creating new student object.......");
		Student tempStudent1 = new Student("John", "Doe", "john.spring@udemy.com" );
		Student tempStudent2 = new Student("Mary", "Doe", "mary.spring@udemy.com" );
		Student tempStudent3 = new Student("Bonita", "Doe", "bonita.spring@udemy.com" );
		// Saving students
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAOImpl studentDAO) {
		
		// Create student object 
		System.out.println("Creating new student object.......");
		Student tempStudent = new Student("Paul", "Doe", "demo.spring@udemy.com" );
		
		// Save the student object 
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		
		// Display the ID for the saved student
		System.out.println("Display the id for the newly inserted student" + tempStudent.getId());
	}
}
