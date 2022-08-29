package com.lti.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.ScholarshipApplication;

public interface ScholarshipApplicationRepo extends JpaRepository<ScholarshipApplication,Integer>{
	
	@Query("Select sa from ScholarshipApplication sa where sa.student.studentId=?1")
	ScholarshipApplication findApplicationByStudentId(int studentId);
	
	@Query("Select sa from ScholarshipApplication sa where "
			+ "sa.student.studentId=?1 and sa.scholarshipType.scholarshipId=?2")
	ScholarshipApplication findScholarshipByStudentIdAndType(int studentId,int scholarshipId);
	
	@Query("Select a from ScholarshipApplication a where a.student.institute.instituteId=?1")
	List<ScholarshipApplication> getAllScholarshipApplicationsByInstituteId(int instituteId);
	
	@Query("Select sa from ScholarshipApplication sa where sa.scholarshipStatus.approvedByInstitute = 1")
	List<ScholarshipApplication> getllScholarshipApplicationsForSNO();
	
	@Query("Select sa from ScholarshipApplication sa where sa.scholarshipStatus.approvedByState = 1")
	List<ScholarshipApplication> getllScholarshipApplicationsForMinistry();
	
	
	
}
