package com.lti.entity;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@MappedSuperclass
public class InstituteStatus extends BaseEntity {
	private int approvedByState;
	private int approvedByMinistry;
}
