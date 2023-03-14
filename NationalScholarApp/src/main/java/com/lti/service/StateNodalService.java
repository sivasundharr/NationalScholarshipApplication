package com.lti.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.StateNodal;
import com.lti.repo.StateNodalRepo;

@Service
public class StateNodalService {
	
	@Autowired
	private StateNodalRepo stateNodalRepo;
	
	
	public StateNodal registerSNO(StateNodal sno) {
		return stateNodalRepo.save(sno);
	}
	
	public StateNodal login(String userName,String password) {
		return stateNodalRepo.findByUserNameAndPassword(userName, password);
	}
	
	
}
