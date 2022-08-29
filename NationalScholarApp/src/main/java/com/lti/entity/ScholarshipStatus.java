package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="nsp_scholarship_status")
public class ScholarshipStatus {
	
	@Id
	@GeneratedValue(generator = "sch_status_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sch_status_seq", initialValue = 4780, allocationSize = 1)
	int applicationStatusId;
	
	boolean approvedByInstitute;
	
	boolean approvedByState;
	
	boolean approvedByMinistry;
	
	@OneToOne
	@JoinColumn(name="scholarshipId")
	ScholarshipApplication scholarshipApplication;
	
	public ScholarshipStatus() {
		
	}

	public ScholarshipStatus(boolean approvedByInstitute, boolean approvedByState, boolean approvedByMinistry,
			ScholarshipApplication scholarshipApplication) {
		this.approvedByInstitute = approvedByInstitute;
		this.approvedByState = approvedByState;
		this.approvedByMinistry = approvedByMinistry;
		this.scholarshipApplication = scholarshipApplication;
	}

	public int getApplicationStatusId() {
		return applicationStatusId;
	}

	public void setApplicationStatusId(int applicationStatusId) {
		this.applicationStatusId = applicationStatusId;
	}

	public boolean isApprovedByInstitute() {
		return approvedByInstitute;
	}

	public void setApprovedByInstitute(boolean approvedByInstitute) {
		this.approvedByInstitute = approvedByInstitute;
	}

	public boolean isApprovedByState() {
		return approvedByState;
	}

	public void setApprovedByState(boolean approvedByState) {
		this.approvedByState = approvedByState;
	}

	public boolean isApprovedByMinistry() {
		return approvedByMinistry;
	}

	public void setApprovedByMinistry(boolean approvedByMinistry) {
		this.approvedByMinistry = approvedByMinistry;
	}

	public ScholarshipApplication getScholarshipApplication() {
		return scholarshipApplication;
	}

	public void setScholarshipApplication(ScholarshipApplication scholarshipApplication) {
		this.scholarshipApplication = scholarshipApplication;
	}
	
}
