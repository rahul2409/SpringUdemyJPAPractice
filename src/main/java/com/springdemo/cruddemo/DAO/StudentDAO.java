package com.springdemo.cruddemo.DAO;

import java.util.*;
import com.springdemo.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();

	List<Student> findByLastName(String theLastName);
	
	void update(Student theStudent);
	
	void delete(Integer id);
}
