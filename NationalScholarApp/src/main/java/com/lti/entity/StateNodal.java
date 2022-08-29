package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class StateNodal {
	@Id
	@GeneratedValue(generator = "state_nodal_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "state_nodal_seq", initialValue = 250, allocationSize = 1)
	int stateNodalOfficerId;

	String email;
	String password;
	String name;
	
	@Enumerated(EnumType.STRING)
	States state = States.MUMBAI;
	
	public StateNodal() {
		
	}

	public StateNodal(String email, String password, String name, States state) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.state = state;
	}

	public int getStateNodalOfficerId() {
		return stateNodalOfficerId;
	}

	public void setStateNodalOfficerId(int stateNodalOfficerId) {
		this.stateNodalOfficerId = stateNodalOfficerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
	
	
	
	
}
