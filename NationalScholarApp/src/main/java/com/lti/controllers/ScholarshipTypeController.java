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

import com.lti.entity.ScholarshipType;
import com.lti.service.ScholarshipTypeService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/scholar-type")
public class ScholarshipTypeController {
	
	@Autowired
	private ScholarshipTypeService scholarshipTypeService;
	
	@PostMapping
	public ScholarshipType addScholarshipType(@RequestBody ScholarshipType scholarType) {
		return scholarshipTypeService.addScholarshipType(scholarType);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findScholarshipById(@PathVariable("id") int id) {
		Optional<ScholarshipType> st = scholarshipTypeService.searchByScholarshipTypeId(id);
		if(st.isPresent()) {
			return new ResponseEntity<ScholarshipType>(st.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
