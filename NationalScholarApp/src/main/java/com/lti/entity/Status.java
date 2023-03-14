package com.lti.entity;

public enum Status {
	PENDING(0,"Pending"),
	APPROVED(1,"Approved"),
	REJECTED(-1,"Rejected");
	
	int status;
	String message;
	private Status(int status,String message) {
		this.status = status;
		this.message = message;
	}
	public String message() {
		return this.message;
	}
	public int getStatus() {
		return this.status;
	}
	public String toString() {
		return String.valueOf(status);
	}
}
