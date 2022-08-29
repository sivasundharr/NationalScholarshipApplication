package com.lti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.ScholarshipStatus;
import com.lti.repo.ScholarshipStatusRepo;

@Service
public class ScholarshipStatusService {
	
	@Autowired
	private ScholarshipStatusRepo statusRepo;
	
	
	public ScholarshipStatus addScholarshipStatus(ScholarshipStatus status) {
		return statusRepo.save(status);
	}
	
	public Optional<ScholarshipStatus> findById(int id) {
		return statusRepo.findById(id);
	}
	
	public ScholarshipStatus getScholarshipStatusByStudentId(int id) {
		return statusRepo.findScholarshipStatusByStudentId(id);
	}
	
	public ScholarshipStatus getScholarshipStatusBySchApplicationId(int applicationId) {
		return statusRepo.findScholarshipStatusByApplicationId(applicationId);
	}

}
