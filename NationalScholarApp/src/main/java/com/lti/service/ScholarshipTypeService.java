package com.lti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.ScholarshipType;
import com.lti.repo.ScholarshipTypeRepo;

@Service
public class ScholarshipTypeService {
	
	@Autowired
	private ScholarshipTypeRepo typeRepo;
	
	public ScholarshipType addScholarshipType(ScholarshipType scholarshipType) {		
		return typeRepo.save(scholarshipType);
	}
	
	public Optional<ScholarshipType> searchByScholarshipTypeId(int id) {
		return typeRepo.findById(id);
	}
	

}
