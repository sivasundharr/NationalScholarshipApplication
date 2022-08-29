package com.lti.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.ScholarshipStatus;
import com.lti.service.ScholarshipStatusService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/status")
public class ScholarshipStatusController {
	
	@Autowired
	private ScholarshipStatusService statusService;
	
	@PostMapping
	public ScholarshipStatus addScholarshipStatus(
			@RequestBody ScholarshipStatus status) {
		return statusService.addScholarshipStatus(status);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByStatusId(@PathVariable("id") int id) {
		Optional<ScholarshipStatus> Ss = statusService.findById(id);
		if(Ss.isPresent()) {
			return new ResponseEntity<ScholarshipStatus>(Ss.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> findByStudentId(@PathVariable("id") int id) {
		ScholarshipStatus Ss = statusService.getScholarshipStatusByStudentId(id);
		if(Ss!=null) {
			return new ResponseEntity<ScholarshipStatus>(Ss,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
