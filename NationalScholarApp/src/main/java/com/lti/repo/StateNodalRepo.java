package com.lti.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.StateNodal;

public interface StateNodalRepo extends JpaRepository<StateNodal, Integer> {
	
	@Query("select st from StateNodal st where st.email=?1 and st.password=?2")
	StateNodal findEmailPasswordEqulas(String email,String password);
	
	
	
}
