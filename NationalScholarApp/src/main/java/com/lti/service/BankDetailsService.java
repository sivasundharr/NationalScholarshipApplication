package com.lti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.BankDetails;
import com.lti.repo.BankDetailsRepo;

@Service
public class BankDetailsService {
	
	@Autowired
	private BankDetailsRepo bankDetailsRepo;
	
	public Optional<BankDetails> serachById(int id) {
		return bankDetailsRepo.findById(id);
	}
	
	public BankDetails addBankDetails(BankDetails bank) {
		return bankDetailsRepo.save(bank);
	}
	
	public BankDetails serachBankDetailsByStudentId(int studentId) {
		return bankDetailsRepo.findBankDetailsByStudentid(studentId);
	}

}
