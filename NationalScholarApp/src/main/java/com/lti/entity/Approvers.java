package com.lti.entity;

public enum Approvers {
	INSTITUTE(1),
	STATENODALOFFICER(2),
	MINISTRY(3);
	int value;
	private Approvers(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public String toString() {
		return String.valueOf(value);
	}
}
