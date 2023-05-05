package com.springdemo.cruddemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	// Define field for entity Manager
	private EntityManager entityManager;
	
	// Inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// Implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		// Create query 
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		
		// return Query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		// Create query 
		TypedQuery<Student> theQuery = entityManager.createQuery(
				"FROM Student WHERE lastName=:theData", 
				Student.class);
		// set query parameter 
		theQuery.setParameter("theData", theLastName);
		// Return Query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		// Retrieve the student
		Student tempStudent = entityManager.find(Student.class, id);
		
		// Delete the student.
		entityManager.remove(tempStudent);
		
	}
	

}

