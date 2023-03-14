package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ScholarshipType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int scholarshipTypeId;
	@Column(nullable=false)
	private String scholarshipName;

}
