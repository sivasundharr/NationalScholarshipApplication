package com.lti.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	@Query("select s from Student s where s.email=?1 and s.password=?2")
	Student findEmailPasswordEqulas(String email,String password);
	
	Student findByEmail(String email);
}
