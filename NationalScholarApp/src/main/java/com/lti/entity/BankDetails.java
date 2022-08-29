package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class BankDetails {
	
	@Id
	@GeneratedValue(generator = "bank_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="bank_seq",initialValue=5000,allocationSize=1)
	int bankDetailsId;
	
	String accountNo;
	String holderName;
	String ifscCode;

	@OneToOne
	@JoinColumn(name = "studentId")
	Student student;

	public int getBankDetailsId() {
		return bankDetailsId;
	}

	public void setBankDetailsId(int bankDetailsId) {
		this.bankDetailsId = bankDetailsId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
