package com.lti.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.ScholarshipStatus;

public interface ScholarshipStatusRepo extends JpaRepository<ScholarshipStatus, Integer> {
	
	@Query("Select s from ScholarshipStatus s where s.scholarshipApplication.student.studentId = ?1")
	ScholarshipStatus findScholarshipStatusByStudentId(Integer id);
	
	
	@Query("select s from ScholarshipStatus s where s.scholarshipApplication.scholarshipId=?1")
	ScholarshipStatus findScholarshipStatusByApplicationId(Integer id);
}
