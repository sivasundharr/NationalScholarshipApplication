package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ApproveDto;
import com.lti.entity.ScholarshipStatus;

@Service
public class ApproveScholarshipService {
	
	@Autowired
	private ScholarshipStatusService schStatusService;
	
	public String approve(ApproveDto ad) {
		
		ScholarshipStatus schStatus;
		try {
			schStatus = schStatusService.getScholarshipStatusBySchApplicationId(ad.getScholarshipId());
		} catch (Exception e) {
			return "Invalid Request";
		}
		if(ad.getApprover()==1) {
			schStatus.setApprovedByInstitute(ad.isApproved());
			schStatusService.addScholarshipStatus(schStatus);
		} else if (ad.getApprover()==2) {
			schStatus.setApprovedByState(ad.isApproved());
			schStatusService.addScholarshipStatus(schStatus);
		} else if (ad.getApprover()==3) {
			schStatus.setApprovedByMinistry(ad.isApproved());
			schStatusService.addScholarshipStatus(schStatus);
		} else {
			return "Corrupt Request";
		}
		return "Success";
	}

}



