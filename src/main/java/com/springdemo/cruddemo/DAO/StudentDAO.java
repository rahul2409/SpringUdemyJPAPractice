package com.springdemo.cruddemo.DAO;

import com.springdemo.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	void findById(int id);
}
