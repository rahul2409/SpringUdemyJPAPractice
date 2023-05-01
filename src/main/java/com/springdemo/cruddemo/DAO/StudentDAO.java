package com.springdemo.cruddemo.DAO;

import com.springdemo.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	Student findById(int id);
}
