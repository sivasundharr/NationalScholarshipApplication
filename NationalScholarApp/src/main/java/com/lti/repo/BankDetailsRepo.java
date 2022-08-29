package com.lti.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.BankDetails;

public interface BankDetailsRepo  extends JpaRepository<BankDetails,Integer>{
	
	@Query("Select bd from BankDetails bd where bd.student.studentId=?1")
	BankDetails findBankDetailsByStudentid(int studentId);
	
}
