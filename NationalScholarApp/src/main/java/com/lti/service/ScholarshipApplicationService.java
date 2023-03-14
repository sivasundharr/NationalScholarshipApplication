package com.lti.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import com.lti.dto.DocumentsDto;
import com.lti.dto.ScholarshipApplicationDto;
import com.lti.dto.ScholarshipFormDto;
import com.lti.entity.ScholarshipApplication;
import com.lti.entity.ScholarshipDocuments;
import com.lti.entity.States;
import com.lti.entity.Student;
import com.lti.exception.ResourceNotFoundException;
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
	private ScholarshipDocumentsService schDocsService;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Transactional
	public ScholarshipApplication applyForScholarship(ScholarshipApplicationDto sAppDto) {
		
		Student stud;
//		Eligibility eligibility;
		ScholarshipApplication schApp = new ScholarshipApplication();
		
		stud = studService.getById(sAppDto.getStudent());
		if(stud == null)
			throw new ResourceNotFoundException("user not found");
		var schType = schTypeService.
				searchByScholarshipTypeId(sAppDto.getSchType()).get();
		
		int scAppId = 
				searchScholarshipApplicationByStudentId(stud.getStudentId())
				.getScholarshipId();
		if(scAppId>0)
		schApp.setScholarshipId(scAppId);

		schApp.setAddmissionFee(sAppDto.getAddmissionFee());
		schApp.setTutionFee(sAppDto.getTutionFee());
		schApp.setBoardName_10(sAppDto.getBoardName_10());
		schApp.setBoardName_12(sAppDto.getBoardName_12());
		schApp.setModeOfStudy(sAppDto.getModeOfStudy());
		schApp.setCurrentYear(sAppDto.getCurrentYear());
		schApp.setPassedYear_10(sAppDto.getPassedYear_10());
		schApp.setPassedYear_12(sAppDto.getPassedYear_12());
		schApp.setOtherFee(sAppDto.getOtherFee());
		schApp.setPercentOfDisability(sAppDto.getPercentOfDisability());
		schApp.setDisabled(sAppDto.isDisabled());
		schApp.setRollNumber_10(sAppDto.getRollNumber_10());
		schApp.setRollNumber_12(sAppDto.getRollNumber_12());
		schApp.setPresentCourseYear(sAppDto.getPresentCourseYear());
		schApp.setPresentCourse(sAppDto.getPresentCourse());
		schApp.setPreviouseCourse(sAppDto.getPreviouseCourse());
		schApp.setPreviouseCoursePer(sAppDto.getPreviouseCoursePer());
		schApp.setStartDate(LocalDate.now());
		schApp.setDisabilityStatus(sAppDto.getDisabilityStatus());
		schApp.setSchType(schType);
		schApp.setStudent(stud);
		schApp.setFamilyAnnualIncome(sAppDto.getFamilyAnnualIncome());
		schApp.setPercent_10(sAppDto.getPercent_10());
		schApp.setPercent_12(sAppDto.getPercent_12());
		schApp.setFatherName(sAppDto.getFatherName());
		schApp.setMotherName(sAppDto.getMotherName());
		schApp.setFatherOccupation(sAppDto.getFatherOccupation());
		schApp.setMotherOccupation(sAppDto.getMotherOccupation());
		ScholarshipApplication sa = scholarRepo.save(schApp);	
		return sa;	
	}
	
	public ScholarshipFormDto convertToFullScholarshipDto(ScholarshipApplication s) {
		TypeMap<ScholarshipApplication,ScholarshipApplicationDto> typeMap=
			modelMapper.getTypeMap(ScholarshipApplication.class,
					ScholarshipApplicationDto.class);
		if(typeMap==null) {
		
			typeMap = modelMapper.createTypeMap(ScholarshipApplication.class,
					ScholarshipApplicationDto.class);
			
			typeMap.addMappings(m->m.map(src->{
				return studService.convertToStudentDto(src.getStudent());
				},ScholarshipApplicationDto::setStudentDto));
			
			typeMap.addMappings(m->m.map(src->src.getScholarshipDocuments(),
					ScholarshipApplicationDto::setScholarshipDocuments));
			typeMap.addMappings(m->m.map(src->src.getSchType()
					,ScholarshipApplicationDto::setScholarshipType));
	
		}
			
			return modelMapper.map(s, ScholarshipFormDto.class);
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
		scholarDocs.setStudentRecord(docDto.getStudentRecord().getOriginalFilename());
		scholarDocs.setScholarship(sApp);
		
		String imageUploadLocation = "C:/Users/Sivasundhar R/Documents/Nsp_files/uploads/"+docDto.getScholarshipId()+"/";
		File f = new File(imageUploadLocation);
		if (!f.exists()) {
			f.mkdir();
		}
		String tAadharCard = imageUploadLocation + docDto.getStudentRecord().getOriginalFilename();

		try {
            FileCopyUtils.copy(docDto.getStudentRecord().getInputStream(), new FileOutputStream(tAadharCard));
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
	
	
	public ScholarshipApplication searchScholarshipApplicationById(Integer applicationId) {
		return scholarRepo.findById(applicationId).get();
	}
	
	public ScholarshipApplication searchScholarshipApplicationByStudentId(Integer studentId) {
		return scholarRepo.findApplicationByStudentId(studentId);
	}
	
	public Set<ScholarshipFormDto> viewAllScholarshipApplicationsByInstitutionCode(String institutionCode){
		return scholarRepo.getScholarshipApplicationsByInstitutionCode(institutionCode)
				.stream()
				.map(this::convertToFullScholarshipDto)
				.collect(Collectors.toSet());
	}
	public Set<ScholarshipFormDto> viewAllScholarshipApplicationsByState(String str){
		States state = States.valueOf(str);
		return scholarRepo.getScholarshipApplicationsByState(state)
				.stream()
				.map(this::convertToFullScholarshipDto)
				.collect(Collectors.toSet());
	}
	public Set<ScholarshipFormDto> viewAllScholarshipApplicationsByMinistry(){
		return scholarRepo.getScholarshipApplicationsByMinistry()
				.stream()
				.map(this::convertToFullScholarshipDto)
				.collect(Collectors.toSet());
	}
	

}
 