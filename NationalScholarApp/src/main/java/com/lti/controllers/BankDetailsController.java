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

import com.lti.entity.BankDetails;
import com.lti.service.BankDetailsService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/bank-details")
public class BankDetailsController {
	
	@Autowired
	private BankDetailsService bankService;
	
	@PostMapping
	public ResponseEntity<?> addBankDetails(@RequestBody BankDetails bankDetails) {
		BankDetails newBankDetails = bankService.addBankDetails(bankDetails);
		if(newBankDetails!=null) return new ResponseEntity<BankDetails>(newBankDetails,HttpStatus.CREATED);
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBankDetailsById(@PathVariable("id") int id){
		Optional<BankDetails> bankDetails = bankService.serachById(id);
		if(bankDetails.isPresent()) return new ResponseEntity<BankDetails>(bankDetails.get(),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<?> getBankDetailsByStudentId(@PathVariable("studentId") int studentId){
		BankDetails bankDetails = bankService.serachBankDetailsByStudentId(studentId);
		if(bankDetails !=null) return new ResponseEntity<BankDetails>(bankDetails,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
