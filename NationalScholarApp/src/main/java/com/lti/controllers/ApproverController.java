package com.lti.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lti.entity.Approvers;
import com.lti.entity.Institute;
import com.lti.entity.ScholarshipApplication;
import com.lti.entity.Status;
import com.lti.repo.InstituteRepo;
import com.lti.repo.ScholarshipApplicationRepo;
import com.lti.service.InstituteService;
import com.lti.service.ScholarshipApplicationService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/approval")
public class ApproverController {
	
	@Autowired
	private InstituteService instituteService;
	
	@Autowired
	private InstituteRepo instituteRepo;
	
	@Autowired
	private ScholarshipApplicationService schService;
	
	@Autowired
	private ScholarshipApplicationRepo schRepo;
	
	@PutMapping("/i/{instituteCode}/{approvedBy}/{status}")
	public ResponseEntity<?> ApproveForInstitute(
			@PathVariable String instituteCode,
			@PathVariable int approvedBy,
			@PathVariable int status
			){
		
		Institute institute = instituteService.getByInstitutionCode(instituteCode);
		
		Optional<Status> st = Arrays.stream(Status.values())
		.filter(s->s.getStatus()==status).findFirst();
		
		Optional<Approvers> ap = Arrays.stream(Approvers.values())
				.filter(a->a.getValue() == approvedBy).findFirst();
		
		if(institute!=null&&(Status.APPROVED.equals(st.get())|| 
				Status.REJECTED.equals(st.get()))) {
			
			Institute newInstitute = institute;
			if(Approvers.STATENODALOFFICER.equals(ap.get())) {
				newInstitute.setApprovedByState(status);
			}
			if(Approvers.MINISTRY.equals(ap.get())) {
				newInstitute.setApprovedByMinistry(status);
			}
			instituteRepo.save(newInstitute);
			Map<String,String> response = new HashMap<>();
			response.put("message",st.get().message());
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{scholarshipId}/{approvedBy}/{status}")
	public ResponseEntity<?> ApproveForScholarship(
			@PathVariable int scholarshipId,
			@PathVariable int approvedBy,
			@PathVariable int status
			){
		
		ScholarshipApplication schApp = schService.searchScholarshipApplicationById(scholarshipId);
		
		Optional<Status> st = Arrays.stream(Status.values())
		.filter(s->s.getStatus()==status).findFirst();
		
		Optional<Approvers> ap = Arrays.stream(Approvers.values())
				.filter(a->a.getValue() == approvedBy).findFirst();
		
		if(schApp !=null &&(Status.APPROVED.equals(st.get())|| 
				Status.REJECTED.equals(st.get()))) {
			
			if(Approvers.INSTITUTE.equals(ap.get())) {
				schApp.setApprovedByInstitute(status);
			}
			
			if(Approvers.STATENODALOFFICER.equals(ap.get())) {
				schApp.setApprovedByState(status);
			}
			if(Approvers.MINISTRY.equals(ap.get())) {
				schApp.setApprovedByMinistry(status);
			}
			schRepo.save(schApp);
			Map<String,String> response = new HashMap<>();
			response.put("message",st.get().message());
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
}
