package com.lti.repo;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.Institute;
import com.lti.entity.States;


public interface InstituteRepo extends JpaRepository<Institute, Integer> {
	
//	Set<Institute> findAllByApproved(boolean approved);
	Optional<Institute> findByInstitutionCode(String institutionCode);
	
	Institute findByInstitutionCodeAndPassword(String institutionCode,String password);
	
	@Query("select i from Institute i where i.address.state=?1 and i.approvedByState = 0")
	Set<Institute> findByInstitutesWaitingForStateApproval(States state);
	
	@Query("select i from Institute i where i.approvedByState = 1 and i.approvedByMinistry = 0")
	Set<Institute> findByInstitutesWaitingForMinistryApproval();
}
