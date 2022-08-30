package com.lti.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginDto;
import com.lti.dto.ScholarshipFormDto;
import com.lti.entity.Institute;
import com.lti.service.InstituteService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/institute")
public class InstituteController {
	
	@Autowired
	public InstituteService instituteService;
	
	@GetMapping
	public List<Institute> getAllInstitutes(){
		return instituteService.findAllInstitutes();
	}
	
	@PostMapping
	public Institute addInstitute(@RequestBody Institute institute) {
		return instituteService.addInstitute(institute);
	}
	
	@PostMapping("/login")
	public boolean instituteLogin(@RequestBody LoginDto loginData) {
		if(instituteService.login(loginData.getEmail(),loginData.getPassword())) {
			return true;
		}
		return false;
	}
	
	@PutMapping("/{instituteId}")
	public Institute updateInstitute(@RequestBody Institute institute,
			@PathVariable("instituteId") int instituteId) {
		institute.setInstituteId(instituteId);
		return instituteService.addInstitute(institute);
	}
	
	@PutMapping("approve/{instituteId}")
	public Institute updateInstituteApproval(@RequestBody Institute institute,
			@PathVariable("instituteId") int instituteId) {
		institute.setInstituteId(instituteId);
		institute.setApprovalStatus(true);
		return instituteService.addInstitute(institute);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findInstituteById(@PathVariable("id") int id) {
		Optional<Institute> institute =  instituteService.findById(id);
		if(institute.isPresent()) {
			return new ResponseEntity<Institute>(institute.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/viewApplications/{instituteId}")
	public List<ScholarshipFormDto> viewAllScholarshipApplicationsByInstituteId(
			@PathVariable("instituteId") int instituteId){
		return instituteService.viewAllScholarshipForms(instituteId);
	}


}
