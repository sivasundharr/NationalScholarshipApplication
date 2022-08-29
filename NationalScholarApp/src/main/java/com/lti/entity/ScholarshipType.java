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
public class ScholarshipType {
	
	@Id
	@GeneratedValue(generator = "scholarship_type_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "scholarship_type_seq", initialValue = 600, allocationSize = 1)
    int scholarshipId;

	String scholarshipName;
	String eligibilityCriteria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "scholarshipType", cascade = CascadeType.ALL)
	List<ScholarshipApplication> scholarshipApplications;
	
	public ScholarshipType() {
		
	}
	
	public ScholarshipType(String scholarshipName, String eligibilityCriteria) {
	
		this.scholarshipName = scholarshipName;
		this.eligibilityCriteria = eligibilityCriteria;
	}


	public ScholarshipType(String scholarshipName, String eligibilityCriteria,
			List<ScholarshipApplication> scholarshipApplications) {
		
		this.scholarshipName = scholarshipName;
		this.eligibilityCriteria = eligibilityCriteria;
		this.scholarshipApplications = scholarshipApplications;
	}

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public String getScholarshipName() {
		return scholarshipName;
	}

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public List<ScholarshipApplication> getScholarshipApplications() {
		return scholarshipApplications;
	}

	public void setScholarshipApplications(List<ScholarshipApplication> scholarshipApplications) {
		this.scholarshipApplications = scholarshipApplications;
	}

	
}
