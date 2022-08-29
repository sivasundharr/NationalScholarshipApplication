package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ScholarshipApplication {
	
	@Id
	@GeneratedValue(generator = "scholarship_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "scholarship_seq", initialValue = 12500, allocationSize = 1)
	int scholarshipId;

	String caste;
	String religion;
	LocalDate dateApplied;
	double tenthPercentage;
	double twelfthPercentage;
	String fatherName;
	String motherName;
	String fatherOccupation;
	String motherOccupation;
	double annualIncome;
	String fatherAadhaarNo;
	String motherAadhaarNo;
	
	@Enumerated(EnumType.STRING)
	DisabilityStatus disabilityStatus = DisabilityStatus.NONE;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "scholarshipType")
	ScholarshipType scholarshipType;
	@JsonIgnore
	@OneToOne(mappedBy = "scholarship", cascade = CascadeType.ALL)
	ScholarshipDocuments scholarshipDocuments;
	@JsonIgnore
	@OneToOne(mappedBy = "scholarshipApplication",cascade = CascadeType.ALL)
	ScholarshipStatus scholarshipStatus;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "studentId")
	Student student;

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public LocalDate getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}

	public ScholarshipType getScholarshipType() {
		return scholarshipType;
	}

	public void setScholarshipType(ScholarshipType scholarshipType) {
		this.scholarshipType = scholarshipType;
	}

	public double getTenthPercentage() {
		return tenthPercentage;
	}

	public void setTenthPercentage(double tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}

	public double getTwelfthPercentage() {
		return twelfthPercentage;
	}

	public void setTwelfthPercentage(double twelfthPercentage) {
		this.twelfthPercentage = twelfthPercentage;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getFatherAadhaarNo() {
		return fatherAadhaarNo;
	}

	public void setFatherAadhaarNo(String fatherAadhaarNo) {
		this.fatherAadhaarNo = fatherAadhaarNo;
	}

	public String getMotherAadhaarNo() {
		return motherAadhaarNo;
	}

	public void setMotherAadhaarNo(String motherAadhaarNo) {
		this.motherAadhaarNo = motherAadhaarNo;
	}

	public ScholarshipDocuments getScholarshipDocuments() {
		return scholarshipDocuments;
	}

	public void setScholarshipDocuments(ScholarshipDocuments scholarshipDocuments) {
		this.scholarshipDocuments = scholarshipDocuments;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public DisabilityStatus getDisabilityStatus() {
		return disabilityStatus;
	}

	public void setDisabilityStatus(DisabilityStatus disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}

	public ScholarshipStatus getScholarshipStatus() {
		return scholarshipStatus;
	}

	public void setScholarshipStatus(ScholarshipStatus scholarshipStatus) {
		this.scholarshipStatus = scholarshipStatus;
	}

	@Override
	public String toString() {
		return "ScholarshipApplication [scholarshipId=" + scholarshipId + ", caste=" + caste + ", religion=" + religion
				+ ", dateApplied=" + dateApplied + ", tenthPercentage=" + tenthPercentage + ", twelfthPercentage="
				+ twelfthPercentage + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", fatherOccupation=" + fatherOccupation + ", motherOccupation=" + motherOccupation
				+ ", annualIncome=" + annualIncome + ", fatherAadhaarNo=" + fatherAadhaarNo + ", motherAadhaarNo="
				+ motherAadhaarNo + ", disabilityStatus=" + disabilityStatus + ", scholarshipType=" + scholarshipType
				+ ", scholarshipDocuments=" + scholarshipDocuments + ", scholarshipStatus=" + scholarshipStatus
				+ ", student=" + student + "]";
	}
	
	

}
