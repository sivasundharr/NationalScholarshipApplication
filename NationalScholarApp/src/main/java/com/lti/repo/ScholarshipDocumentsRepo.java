package com.lti.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.ScholarshipDocuments;

public interface ScholarshipDocumentsRepo extends JpaRepository<ScholarshipDocuments,Integer> {
	
	@Query("Select sd from ScholarshipDocuments sd where sd.scholarship.scholarshipId=?1")
	ScholarshipDocuments findScholarshipDocumentsByScholarshipId(int scholarId);
	
	@Query("Select sd from ScholarshipDocuments sd where sd.scholarship.student.studentId=?1")
	ScholarshipDocuments findScholarshipDocumentsByStudentId(int studentId);
}
