package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.MinistryDto;
import com.lti.dto.ScholarshipFormDto;
import com.lti.entity.BankDetails;
import com.lti.entity.ScholarshipApplication;
import com.lti.entity.ScholarshipDocuments;
import com.lti.entity.Student;

@Service
public class MinistryService {
	

	@Autowired
	private ScholarshipApplicationService schAppService;
	
	@Autowired
	private BankDetailsService bankDetailsService;
	
	@Autowired
	private ScholarshipDocumentsService schDocsService;
	
	public boolean login(MinistryDto mDto) {
		if (mDto.getId() == 1 && mDto.getPassword().equals("pass")) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<ScholarshipFormDto> viewMinistryApplications(){
		
		List<ScholarshipFormDto> list = new ArrayList<ScholarshipFormDto>();
		
		List<ScholarshipApplication> sa = schAppService.viewAllScholarshipApplicationsForMinistry();
		
		sa.stream().forEach(s->{
			
			Student stu = s.getStudent();
			int sid = stu.getStudentId();
			ScholarshipFormDto sf = new ScholarshipFormDto();
			BankDetails bd = bankDetailsService.serachBankDetailsByStudentId(sid);
			ScholarshipDocuments sd = schDocsService.searchScholarshipDocumentsByStudentId(sid);
			if(sd!=null) {
			
			sf.setStudentId(stu.getStudentId());
			sf.setName(stu.getName());
			sf.setAadharNumber(stu.getAadharNumber());
			sf.setDob(stu.getDob());
			sf.setGender(stu.getGender());
			sf.setEmailId(stu.getEmail());
			sf.setMobileNumber(stu.getMobileNumber());

			sf.setScholarshipId(s.getScholarshipId());
			sf.setCaste(s.getCaste());
			sf.setReligion(s.getReligion());
			sf.setDisabilityStatus(s.getDisabilityStatus().toString());
			sf.setScholarshipType(s.getScholarshipType().getScholarshipId());
			sf.setTenthPercentage(s.getTenthPercentage());
			sf.setTwelfthPercentage(s.getTwelfthPercentage());
			sf.setFatherName(s.getFatherName());
			sf.setMotherName(s.getMotherName());
			sf.setFatherOccupation(s.getFatherOccupation());
			sf.setMotherOccupation(s.getMotherOccupation());
			sf.setAnnualIncome(s.getAnnualIncome());
			sf.setFatherAadhaarNo(s.getFatherAadhaarNo());
			sf.setMotherAadhaarNo(s.getMotherAadhaarNo());
			
			
			sf.setBankDetailsId(bd.getBankDetailsId());
			sf.setAccountNo(bd.getAccountNo());
			sf.setHolderName(bd.getHolderName());
			sf.setIfscCode(bd.getIfscCode());
			
			sf.setScholarshipDocumentsId(sd.getScholarshipDocumentsId());
			sf.setAadharCard(sd.getAadharCard());
			sf.setTenthMarksheet(sd.getTenthMarksheet());
			sf.setTwelfthMarksheet(sd.getTwelfthMarksheet());
			sf.setPhoto(sd.getPhoto());
			sf.setIdCard(sd.getIdCard());
			sf.setCasteOrIncomeCertificate(sd.getCasteOrIncomeCertificate());
			sf.setFeeReciept(sd.getFeeReciept());
			sf.setPassBook(sd.getPassBook());
			sf.setDomecile(sd.getDomecile());
			
			list.add(sf);
			}
		});
		
		
		return list;
		
	}

}
