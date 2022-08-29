package com.lti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.MinistryDto;
import com.lti.dto.ScholarshipFormDto;
import com.lti.service.MinistryService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/ministry")
public class MinsitryController {
	
	@Autowired
	private MinistryService ministryService;
	
	@PostMapping("/login")
	public boolean ministryLogin(@RequestBody MinistryDto ministryData) {
		return ministryService.login(ministryData);
	}
	
	@GetMapping("/viewApplications")
	public List<ScholarshipFormDto> viewAllScholarshipsForMinistry(){
		return ministryService.viewMinistryApplications();
	}

}
