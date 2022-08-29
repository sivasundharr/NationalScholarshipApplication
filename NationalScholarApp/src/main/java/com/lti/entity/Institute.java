package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Institute {
	
	@Id
	@SequenceGenerator(name = "inst_seq", initialValue = 13000, allocationSize = 1)
	@GeneratedValue(generator = "inst_seq", strategy = GenerationType.SEQUENCE) 
	int instituteId;
	
	String instituteCategory;
	String email;
	String password;
	String name;
	String instituteType;
	String afiliatedState;
	String address;
	String state;
	String district;
	String pincode;
	String diseCode;
	String location;
	String universityName;
	String principalName;
	String mobileNumber;
	String telephoneNumber;
	String boardname;
	boolean approvalStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "institute", cascade = CascadeType.ALL)
	List<Student> students;
	
	public Institute() {
		
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getInstituteCategory() {
		return instituteCategory;
	}

	public void setInstituteCategory(String instituteCategory) {
		this.instituteCategory = instituteCategory;
	}

	public String getInstituteType() {
		return instituteType;
	}

	public void setInstituteType(String instituteType) {
		this.instituteType = instituteType;
	}

	public String getAfiliatedState() {
		return afiliatedState;
	}

	public void setAfiliatedState(String afiliatedState) {
		this.afiliatedState = afiliatedState;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDiseCode() {
		return diseCode;
	}

	public void setDiseCode(String diseCode) {
		this.diseCode = diseCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getBoardname() {
		return boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	
}
