package com.lti.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.lti.dto.DocumentsDto;
import com.lti.dto.ScholarshipApplicationDto;
import com.lti.entity.BankDetails;
import com.lti.entity.DisabilityStatus;
import com.lti.entity.ScholarshipApplication;
import com.lti.entity.ScholarshipDocuments;
import com.lti.entity.ScholarshipStatus;
import com.lti.entity.Student;
import com.lti.repo.ScholarshipApplicationRepo;

@Service
public class ScholarshipApplicationService {
	
	@Autowired
	private ScholarshipApplicationRepo scholarRepo;
	
	@Autowired
	private StudentService studService;
	
	@Autowired
	private ScholarshipTypeService schTypeService;
	
	@Autowired
	private ScholarshipStatusService statusService;
	
	@Autowired
	private BankDetailsService bankDetails;
	
	@Autowired
	private ScholarshipDocumentsService schDocsService;
	
	
	
	public String applyForScholarship(ScholarshipApplicationDto sAppDto) {
		Student stud;
		ScholarshipApplication schApp = new ScholarshipApplication();
		ScholarshipStatus schStatus = new ScholarshipStatus();
		BankDetails bank = new BankDetails();
		try {
			stud = studService.searchByStudentId(sAppDto.getStudentId()).get();
		}catch(Exception e){
			return "failure";
		}
		
		try {
			int scAppId = searchScholarshipApplicationByStudentId(sAppDto.getStudentId()).getScholarshipId();
			schApp.setScholarshipId(scAppId);
		}catch(Exception e) {
			System.out.println("error for fetching application id");
		}
		
		schApp.setCaste(sAppDto.getCaste());
		schApp.setReligion(sAppDto.getReligion());
		schApp.setDisabilityStatus(DisabilityStatus.valueOf(sAppDto.getDisabilityStatus()));
		schApp.setScholarshipType(schTypeService.searchByScholarshipTypeId(sAppDto.getScholarshipType()).get());
		schApp.setDateApplied(LocalDate.now());
		schApp.setStudent(stud);
		schApp.setAnnualIncome(sAppDto.getAnnualIncome());
		schApp.setTenthPercentage(sAppDto.getTenthPercentage());
		schApp.setTwelfthPercentage(sAppDto.getTwelfthPercentage());
		schApp.setFatherName(sAppDto.getFatherName());
		schApp.setMotherName(sAppDto.getMotherName());
		schApp.setFatherOccupation(sAppDto.getFatherOccupation());
		schApp.setMotherOccupation(sAppDto.getMotherOccupation());
		schApp.setFatherAadhaarNo(sAppDto.getFatherAadhaarNo());
		schApp.setMotherAadhaarNo(sAppDto.getMotherAadhaarNo());
		
		try {
			int bankId = bankDetails.serachBankDetailsByStudentId(sAppDto.getStudentId()).getBankDetailsId();
			bank.setBankDetailsId(bankId);
		}catch(Exception e) {
			
		}
		bank.setAccountNo(sAppDto.getAccountNo());
		bank.setHolderName(sAppDto.getHolderName());
		bank.setIfscCode(sAppDto.getIfscCode());
		bank.setStudent(stud);
		
		try {
			bankDetails.addBankDetails(bank);
			System.out.println(schApp);
			ScholarshipApplication sa = addScholarshipForm(schApp);
			
			try {
			int statusId = statusService.getScholarshipStatusBySchApplicationId(
			searchScholarshipApplicationByStudentId(sAppDto.getStudentId()).getScholarshipId()).getApplicationStatusId();
			schStatus.setApplicationStatusId(statusId);
			}catch(Exception e) {
				
			}
			schStatus.setScholarshipApplication(sa);
			statusService.addScholarshipStatus(schStatus);
			
			return "Success";
		}catch(Exception e) {
			return "Unsuccessful";
		}
	}
	
	public String uploadDocuments(DocumentsDto docDto) {
		ScholarshipDocuments scholarDocs = new ScholarshipDocuments();
		ScholarshipApplication sApp = searchScholarshipApplicationById(docDto.getScholarshipId());
		
		try {
			int fdId = schDocsService.
					searchScholarshipDocumentsByScholarshipId(docDto.getScholarshipId()).
					getScholarshipDocumentsId();
			scholarDocs.setScholarshipDocumentsId(fdId);
			
		} catch (Exception e){
			//new entry if error
		}
		scholarDocs.setAadharCard(docDto.getAadharCard().getOriginalFilename());
		scholarDocs.setCasteOrIncomeCertificate(docDto.getCasteOrIncomeCertificate().getOriginalFilename());
		scholarDocs.setDomecile(docDto.getDomecile().getOriginalFilename());
		scholarDocs.setFeeReciept(docDto.getFeeReciept().getOriginalFilename());
		scholarDocs.setTenthMarksheet(docDto.getTenthMarksheet().getOriginalFilename());
		scholarDocs.setTwelfthMarksheet(docDto.getTwelfthMarksheet().getOriginalFilename());
		scholarDocs.setIdCard(docDto.getIdCard().getOriginalFilename());
		scholarDocs.setPassBook(docDto.getPassBook().getOriginalFilename());
		scholarDocs.setPhoto(docDto.getPhoto().getOriginalFilename());
		scholarDocs.setScholarship(sApp);
		
		String imageUploadLocation = "C:/Users/Sivasundhar R/Documents/Nsp_files/uploads/"+docDto.getScholarshipId()+"/";
		File f = new File(imageUploadLocation);
		if (!f.exists()) {
			f.mkdir();
		}
		String tAadharCard = imageUploadLocation + docDto.getAadharCard().getOriginalFilename();
		String tTenthMarksheet = imageUploadLocation + docDto.getTenthMarksheet().getOriginalFilename();
		String tTwelfthMarksheet = imageUploadLocation + docDto.getTwelfthMarksheet().getOriginalFilename();
		String tPhoto = imageUploadLocation + docDto.getPhoto().getOriginalFilename();
		String tIdCard = imageUploadLocation + docDto.getIdCard().getOriginalFilename();
		String tCasteOrIncomeCertificate = imageUploadLocation + docDto.getCasteOrIncomeCertificate().getOriginalFilename();
		String tFeeReciept = imageUploadLocation + docDto.getFeeReciept().getOriginalFilename();
		String tPassBook = imageUploadLocation + docDto.getPassBook().getOriginalFilename();
		String tDomecile = imageUploadLocation + docDto.getDomecile().getOriginalFilename();

		try {
            FileCopyUtils.copy(docDto.getAadharCard().getInputStream(), new FileOutputStream(tAadharCard));
            FileCopyUtils.copy(docDto.getTenthMarksheet().getInputStream(), new FileOutputStream(tTenthMarksheet));
            FileCopyUtils.copy(docDto.getTwelfthMarksheet().getInputStream(), new FileOutputStream(tTwelfthMarksheet));
            FileCopyUtils.copy(docDto.getPhoto().getInputStream(), new FileOutputStream(tPhoto));
            FileCopyUtils.copy(docDto.getIdCard().getInputStream(), new FileOutputStream(tIdCard));
            FileCopyUtils.copy(docDto.getCasteOrIncomeCertificate().getInputStream(), new FileOutputStream(tCasteOrIncomeCertificate));
            FileCopyUtils.copy(docDto.getFeeReciept().getInputStream(), new FileOutputStream(tFeeReciept));
            FileCopyUtils.copy(docDto.getPassBook().getInputStream(), new FileOutputStream(tDomecile));
            FileCopyUtils.copy(docDto.getDomecile().getInputStream(), new FileOutputStream(tPassBook));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
		try {
			schDocsService.addOrUpdateScholarshipDocuments(scholarDocs);
			return "Success";
		} catch (Exception e) {
			return "Unexpected Error Occured";
		}
	}
	
	public ScholarshipApplication addScholarshipForm(ScholarshipApplication scholarapp) {
		System.out.println("inside add form");
		return scholarRepo.save(scholarapp);
	}
	
	public ScholarshipApplication searchScholarshipApplicationById(Integer applicationId) {
		return scholarRepo.findById(applicationId).get();
	}
	
	public List<ScholarshipApplication> getAllApplications(){
		return scholarRepo.findAll();
	}

	public ScholarshipApplication searchScholarshipApplicationByStudentId(Integer studentId) {
		return scholarRepo.findApplicationByStudentId(studentId);
	}

	public ScholarshipApplication searchScholarshipApplicationByStudentIdAndType(int studentId, int scholarshipId){
		return scholarRepo.findScholarshipByStudentIdAndType(studentId,scholarshipId);
	}
	
	public List<ScholarshipApplication> viewAllScholarshipApplicationsByInstituteId(int instituteId){
		return scholarRepo.getAllScholarshipApplicationsByInstituteId(instituteId);
	}
	public List<ScholarshipApplication> viewAllScholarshipApplicationsForSo(){
		return scholarRepo.getllScholarshipApplicationsForSNO();
	}
	public List<ScholarshipApplication> viewAllScholarshipApplicationsForMinistry(){
		return scholarRepo.getllScholarshipApplicationsForMinistry();
	}

}
