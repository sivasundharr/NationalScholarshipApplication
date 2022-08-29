package com.lti.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.entity.ScholarshipType;

public interface ScholarshipTypeRepo extends JpaRepository<ScholarshipType, Integer> {
	
}
