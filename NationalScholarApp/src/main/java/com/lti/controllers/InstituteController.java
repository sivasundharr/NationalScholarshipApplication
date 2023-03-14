package com.lti.controllers;

import java.net.URI;
import java.util.Set;

import javax.validation.Valid;

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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lti.dto.InstituteDto;
import com.lti.dto.LoginDto;
import com.lti.dto.LoginResponseDto;
import com.lti.exception.ResourceNotFoundException;
import com.lti.service.InstituteService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/institute")
public class InstituteController {
	
	@Autowired
	public InstituteService instituteService;
	
	@PostMapping
	public ResponseEntity<?> createInstitute(@Valid @RequestBody InstituteDto instituteDto) {
		InstituteDto inst = instituteService.addInstitute(instituteDto);
		if (inst != null) {
			URI uri = ServletUriComponentsBuilder
					.fromCurrentContextPath().path("//institute/{id}")
					.buildAndExpand(inst.getInstitutionCode()).toUri();
			return ResponseEntity.created(uri).build();
		}
			
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> instituteLogin(@Valid @RequestBody LoginDto loginData) {
		InstituteDto institute = instituteService.login(loginData.getUserName(), loginData.getPassword());
		if (institute == null) {
			throw new ResourceNotFoundException("Invalid UserName or Password");
		}
			LoginResponseDto loginResponse = new LoginResponseDto();

			loginResponse.setId(1);
			loginResponse.setName(institute.getInstitutionName());

			return new ResponseEntity<LoginResponseDto>(loginResponse, HttpStatus.OK);
	}
	
	@PutMapping("/{institutionCode}")
	public InstituteDto updateInstitute(@RequestBody InstituteDto instituteDto,
			@PathVariable("instituteId") String institutionCode) {
		instituteDto.setInstitutionCode(institutionCode);
		return instituteService.addInstitute(instituteDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findInstitutionById(@PathVariable("id") int id) {
		InstituteDto institute = instituteService.findById(id);
		if (institute == null)
			throw new ResourceNotFoundException("Institute Not Found");
		return new ResponseEntity<>(institute, HttpStatus.OK);
	}
	
	@GetMapping("/i/{InstituteCode}")
	public ResponseEntity<?> findInstitutionCode(@PathVariable("InstituteCode") String id) {
		InstituteDto institute = instituteService.findByInstituteCode(id);
		if (institute == null)
			throw new ResourceNotFoundException("Institute Not Found");
		return new ResponseEntity<>(institute, HttpStatus.OK);
	}
	
	
	@GetMapping("/state/{state}")
	public ResponseEntity<?> InstitutesByState(@PathVariable String state){
		Set<InstituteDto> institutes;
		try {
		institutes = instituteService
				.findByInstitutesWaitingForStateApproval(state);
		}catch(IllegalArgumentException ex) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,"State doesn't exist",ex);
		}
		return new ResponseEntity<>(institutes,HttpStatus.OK);
	}
	
	@GetMapping("/ministry/")
	public ResponseEntity<?> InstitutesByMinistry(){
		Set<InstituteDto> institutes;
		try {
		institutes = instituteService
				.findByInstitutesWaitingForMinistryApproval();
		}catch(IllegalArgumentException ex) {
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,"something wrong",ex);
		}
		return new ResponseEntity<>(institutes,HttpStatus.OK);
	}
}
