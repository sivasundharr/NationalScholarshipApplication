package com.lti.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.Institute;


public interface InstituteRepo extends JpaRepository<Institute, Integer> {
	
	@Query("select i from Institute i where i.name=?1 and i.password=?2")
	Institute findNamePasswordEqulas(String name,String password);
	
	@Query("select i from Institute i where i.state=?1")
	List<Institute> groupInstitutesByState(String state);

}
