package com.lti.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.InstituteDto;
import com.lti.entity.Institute;
import com.lti.entity.States;
import com.lti.repo.InstituteRepo;

@Service
public class InstituteService {
	
	@Autowired
	private InstituteRepo instituteRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Institute getByInstitutionCode(String institutionCode) {
		return instituteRepo.findByInstitutionCode(institutionCode).orElse(null);
	}
	
	public InstituteDto login(String institutionCode,String password) {
		Institute institute = instituteRepo.findByInstitutionCodeAndPassword(institutionCode, password);
		return convertToInstituteDto(institute);
	
	}
	//@Transactional
	public InstituteDto addInstitute(InstituteDto instituteDto) {
		var newInstitute = instituteRepo
				.save(convertToInstitute(instituteDto));
		return convertToInstituteDto(newInstitute);
	}
	public Institute getById(int institutionId) {
		return instituteRepo.findById(institutionId).orElse(null);
	}
	
	public InstituteDto findById(int institutionId) {
		return convertToInstituteDto(getById(institutionId));
	}
	
	public InstituteDto findByInstituteCode(String institutionCode) {
		return convertToInstituteDto(getByInstitutionCode(institutionCode));
	}
	
	public Set<InstituteDto> findByInstitutesWaitingForStateApproval(String state){
		States newState  = States.valueOf(state);
		return instituteRepo.findByInstitutesWaitingForStateApproval(newState)
			   .stream().map(this::convertToInstituteDto)
			   .collect(Collectors.toSet());
	}
	
	public Set<InstituteDto> findByInstitutesWaitingForMinistryApproval(){
	
		return instituteRepo.findByInstitutesWaitingForMinistryApproval()
			   .stream().map(this::convertToInstituteDto)
			   .collect(Collectors.toSet());
	}
	public InstituteDto convertToInstituteDto(Institute institute) {
		TypeMap<Institute,InstituteDto> tMap = 
				this.modelMapper.getTypeMap(Institute.class, InstituteDto.class); 
		if(tMap == null) {
			tMap = this.modelMapper.createTypeMap(Institute.class,
					InstituteDto.class);
			
			tMap.addMappings(mapper->mapper.skip(InstituteDto::setPassword));
		}
		return this.modelMapper.map(institute, InstituteDto.class);
		
	}
	
	public Institute convertToInstitute(InstituteDto instituteDto) {
		TypeMap<InstituteDto,Institute> tMap = 
				modelMapper.getTypeMap(InstituteDto.class, Institute.class); 
		if(tMap == null) {
			tMap = this.modelMapper.createTypeMap(InstituteDto.class,
					Institute.class);
		}
		return modelMapper.map(instituteDto, Institute.class);
	}

}
 