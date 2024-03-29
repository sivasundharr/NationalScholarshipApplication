package com.lti.entity;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class ScholarshipStatus extends BaseEntity{
	private int approvedByInstitute;
	private int approvedByState;
	private int approvedByMinistry;
}
