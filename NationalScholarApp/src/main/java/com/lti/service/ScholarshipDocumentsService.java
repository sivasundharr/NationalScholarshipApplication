package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.ScholarshipDocuments;
import com.lti.repo.ScholarshipDocumentsRepo;

@Service
public class ScholarshipDocumentsService {
	
	@Autowired
	private ScholarshipDocumentsRepo schDocsRepo;
	
	public ScholarshipDocuments addOrUpdateScholarshipDocuments(ScholarshipDocuments studentDocuments) {
		return schDocsRepo.save(studentDocuments);
	}

	public ScholarshipDocuments searchScholarshipDocumentsById(int schDocumentsId) {
		return schDocsRepo.findById(schDocumentsId).get();
	}

	public ScholarshipDocuments searchScholarshipDocumentsByScholarshipId(int scholarshipId) {
		return schDocsRepo.findScholarshipDocumentsByScholarshipId(scholarshipId);
	}
	
	public ScholarshipDocuments searchScholarshipDocumentsByStudentId(int studentId) {
		return schDocsRepo.findScholarshipDocumentsByStudentId(studentId);
	}
}
