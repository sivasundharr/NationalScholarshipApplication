package com.lti.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DocumentsDto;
import com.lti.dto.ScholarshipApplicationDto;
import com.lti.entity.ScholarshipApplication;
import com.lti.service.ScholarshipApplicationService;

@RequestMapping("/scholar-form")
@CrossOrigin("http://localhost:4200/")
@RestController
public class ScholarshipAppController {
	
	@Autowired
	private ScholarshipApplicationService scholarService;
	
	@PostMapping
	public String applyForScholarship(@RequestBody ScholarshipApplicationDto schDto) {
		return scholarService.applyForScholarship(schDto);
	}
	
	@PostMapping("/upload")
	public String documentUpload(DocumentsDto dDto) {
		return scholarService.uploadDocuments(dDto);
	}
	
	@GetMapping("/institute/{id}")
	public List<ScholarshipApplication> findAllScholarshipApplicationsForInstitute(
			@PathVariable("id") int instituteId){
		return scholarService.viewAllScholarshipApplicationsByInstituteId(instituteId);
	}
	

}
