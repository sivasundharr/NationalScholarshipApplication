package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="nsp_student")
public class Student {
	@Id
	@GeneratedValue(generator = "student_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "student_seq", initialValue = 100, allocationSize = 1)
	int studentId;
	
	String name;
	String dob;
	String mobileNumber;
	String gender;
	String email;
	String aadharNumber;
	String password;
	
	@Transient
	transient int collegeId;
	
	@JsonIgnore
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	BankDetails bankDetails;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "instituteId")
	Institute institute;
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	
	public int getCollegeId() {
		return collegeId;
	}
	
	
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	
	
	
	
}
