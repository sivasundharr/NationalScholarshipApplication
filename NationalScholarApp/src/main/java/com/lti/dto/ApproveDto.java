package com.lti.dto;

public class ApproveDto {
	
	int approver;
	
	int scholarshipId;
	
	boolean approved;

	public int getApprover() {
		return approver;
	}

	public void setApprover(int approver) {
		this.approver = approver;
	}

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	

}
