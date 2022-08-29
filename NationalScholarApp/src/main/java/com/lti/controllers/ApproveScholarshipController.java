package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ApproveDto;
import com.lti.service.ApproveScholarshipService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/approve")
public class ApproveScholarshipController {
	
	@Autowired
	private ApproveScholarshipService approveService;
	
	@PostMapping
	public String approveApplication(@RequestBody ApproveDto adto) {
		return approveService.approve(adto);
	}
}
