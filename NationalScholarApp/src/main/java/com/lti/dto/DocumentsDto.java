package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentsDto {
	
	int scholarshipId;
	
	MultipartFile studentRecord;
	
	public int getScholarshipId() {
		return scholarshipId;
	}
	
	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}
	public MultipartFile getStudentRecord() {
		return studentRecord;
	}
	public void setAadharCard(MultipartFile studentRecord) {
		this.studentRecord = studentRecord;
	}
}
