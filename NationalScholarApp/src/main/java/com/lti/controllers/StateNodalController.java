package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lti.dto.LoginDto;
import com.lti.dto.LoginResponseDto;
import com.lti.entity.StateNodal;
import com.lti.exception.ResourceNotFoundException;
import com.lti.service.StateNodalService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/state-nodal")
public class StateNodalController {

	@Autowired
	private StateNodalService stateNodalService;

	@PostMapping
	public ResponseEntity<?> stateNodalOfficerRegisteration(@RequestBody StateNodal sno) {
		StateNodal sn;
		try {
				sn = stateNodalService.registerSNO(sno);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Field values",ex);
		}
		
		return new ResponseEntity<StateNodal>(sn, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> stateNodalOfficerLogin(@RequestBody LoginDto loginDto) {
		StateNodal sn = stateNodalService.login(loginDto.getUserName(), loginDto.getPassword());
		if (sn == null) 
		{
			throw new ResourceNotFoundException("UserName or password is incorrect");
		}
		LoginResponseDto loginResponse = new LoginResponseDto();
		loginResponse.setId(sn.getStateNodalOfficerId());
		loginResponse.setName(sn.getUserName());
		return new ResponseEntity<LoginResponseDto>(loginResponse, HttpStatus.OK);
	}

	
}
