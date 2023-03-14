package com.lti.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lti.dto.ScholarshipFormDto;
import com.lti.entity.ScholarshipApplication;
import com.lti.service.ScholarshipApplicationService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/full-application")
public class FullApplicationController {
	
	@Autowired
	private ScholarshipApplicationService schAppService;
	
	
	@GetMapping("/{id}")
	public ScholarshipFormDto getSchoalrshipApplication(@PathVariable int id) {
		ScholarshipApplication s = 
				schAppService.searchScholarshipApplicationById(id);
		return schAppService.convertToFullScholarshipDto(s);
	}
	
	@GetMapping("/i-approval/{institutionCode}")
	public ResponseEntity<?> findAllScholarshipApplicationsForInstitute(
			@PathVariable("institutionCode") String institutionCode ){
		Set<ScholarshipFormDto> schApps = new HashSet<>();
		try {
		schApps= schAppService.
				viewAllScholarshipApplicationsByInstitutionCode(institutionCode);
		}catch(Exception ex) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR,"something wrong",ex);
		}
		return new ResponseEntity<Set<ScholarshipFormDto>>
		(schApps,HttpStatus.OK);
	}
	
	@GetMapping("/s-approval/{state}")
	public ResponseEntity<?> findAllScholarshipApplicationsForState(
			@PathVariable("state") String state ){
		Set<ScholarshipFormDto> schApps = new HashSet<>();
		try {
			schApps = schAppService.viewAllScholarshipApplicationsByState(state);
		
		}catch(IllegalArgumentException ex) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,"state doesn't exist",ex);
		}
		return new ResponseEntity<Set<ScholarshipFormDto>>
		(schApps,HttpStatus.OK);
	}
	
	@GetMapping("/m-approval")
	public ResponseEntity<?> findAllScholarshipApplicationsForMinsitry(){
		Set<ScholarshipFormDto> schApps = new HashSet<>();
		try {
		schApps= schAppService.
				viewAllScholarshipApplicationsByMinistry();
		}catch(Exception ex) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR,"something wrong",ex);
		}
		return new ResponseEntity<Set<ScholarshipFormDto>>
		(schApps,HttpStatus.OK);
	}
}
