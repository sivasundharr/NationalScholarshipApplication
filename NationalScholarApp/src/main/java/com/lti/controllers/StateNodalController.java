package com.lti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginDto;
import com.lti.dto.ScholarshipFormDto;
import com.lti.dto.StateNodalLogin;
import com.lti.entity.StateNodal;
import com.lti.service.StateNodalService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/state-nodal")
public class StateNodalController {
	
	@Autowired
	private StateNodalService stateNodalService;
	
	@PostMapping
	public StateNodal stateNodalOfficerRegisteration(@RequestBody StateNodal sno) {
		return stateNodalService.registerSNO(sno);
	}
	
	@PostMapping("/login")
	public boolean stateNodalOfficerLogin(@RequestBody LoginDto loginDto) {
		if(stateNodalService.login(loginDto.getEmail(),loginDto.getPassword())) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/viewApplications")
	public List<ScholarshipFormDto> viewInstituteApplications() {
		return stateNodalService.viewAllApplicationsSo();
	}
}
