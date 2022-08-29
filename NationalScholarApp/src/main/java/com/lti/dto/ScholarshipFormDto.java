package com.lti.dto;

public class ScholarshipFormDto {
	
	//student Table
	int studentId;
	String name;
	String dob;
	String mobileNumber;
	String gender;
	String emailId;
	String aadharNumber;
	
	//scholarhipApplication table
	int scholarshipId;
	String caste;
	String religion;
	String disabilityStatus;
	int scholarshipType;
	double tenthPercentage;
	double twelfthPercentage;
	String fatherName;
	String motherName;
	String fatherOccupation;
	String motherOccupation;
	double annualIncome;
	String fatherAadhaarNo;
	String motherAadhaarNo;
	
	//BankDetails table
	int bankDetailsId;
	String accountNo;
	String holderName;
	String ifscCode;
	
	//student documents
	int scholarshipDocumentsId;
	String aadharCard;
	String tenthMarksheet;
	String twelfthMarksheet;
	String photo;
	String idCard;
	String casteOrIncomeCertificate;
	String feeReciept;
	String passBook;
	String domecile;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
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
	public String getDisabilityStatus() {
		return disabilityStatus;
	}
	public void setDisabilityStatus(String disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}
	public int getScholarshipType() {
		return scholarshipType;
	}
	public void setScholarshipType(int scholarshipType) {
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
		this.fatherName = fatherName;
	}
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
	public int getScholarshipDocumentsId() {
		return scholarshipDocumentsId;
	}
	public void setScholarshipDocumentsId(int scholarshipDocumentsId) {
		this.scholarshipDocumentsId = scholarshipDocumentsId;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getTenthMarksheet() {
		return tenthMarksheet;
	}
	public void setTenthMarksheet(String tenthMarksheet) {
		this.tenthMarksheet = tenthMarksheet;
	}
	public String getTwelfthMarksheet() {
		return twelfthMarksheet;
	}
	public void setTwelfthMarksheet(String twelfthMarksheet) {
		this.twelfthMarksheet = twelfthMarksheet;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCasteOrIncomeCertificate() {
		return casteOrIncomeCertificate;
	}
	public void setCasteOrIncomeCertificate(String casteOrIncomeCertificate) {
		this.casteOrIncomeCertificate = casteOrIncomeCertificate;
	}
	public String getFeeReciept() {
		return feeReciept;
	}
	public void setFeeReciept(String feeReciept) {
		this.feeReciept = feeReciept;
	}
	public String getPassBook() {
		return passBook;
	}
	public void setPassBook(String passBook) {
		this.passBook = passBook;
	}
	public String getDomecile() {
		return domecile;
	}
	public void setDomecile(String domecile) {
		this.domecile = domecile;
	}

}
