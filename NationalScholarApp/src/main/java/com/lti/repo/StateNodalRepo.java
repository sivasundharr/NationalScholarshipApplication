package com.lti.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.entity.StateNodal;

public interface StateNodalRepo extends JpaRepository<StateNodal, Integer> {
	
	
	StateNodal findByUserNameAndPassword(String userName,String password);
	
	
	
}
