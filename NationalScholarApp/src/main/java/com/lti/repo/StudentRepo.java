package com.lti.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	@Query("select s from Student s where s.name=?1 and s.password=?2")
	Student findNamePasswordEqulas(String name,String password);
}
