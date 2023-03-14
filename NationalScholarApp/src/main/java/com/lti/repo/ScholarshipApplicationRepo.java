package com.lti.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.ScholarshipApplication;
import com.lti.entity.States;

public interface ScholarshipApplicationRepo extends JpaRepository<ScholarshipApplication,Integer>{
	
	@Query("Select sa from ScholarshipApplication sa where sa.student.studentId=?1")
	ScholarshipApplication findApplicationByStudentId(int studentId);
		
	@Query("Select a from ScholarshipApplication a where a.student.institute.institutionCode=?1 and a.approvedByInstitute=0")
	Set<ScholarshipApplication> getScholarshipApplicationsByInstitutionCode(String institutionCode);
	
	@Query("Select a from ScholarshipApplication a where a.student.address.state = ?1 and "
			+ "a.approvedByInstitute = 1 and a.approvedByState=0")
	Set<ScholarshipApplication> getScholarshipApplicationsByState(States state);
	
	@Query("Select a from ScholarshipApplication a where "
			+ "a.approvedByInstitute = 1 and a.approvedByState=1 and "
			+ "a.approvedByMinistry=0"
			)
	Set<ScholarshipApplication> getScholarshipApplicationsByMinistry();
}
