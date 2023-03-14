package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class StateNodal {
	@Id
	@GeneratedValue(generator = "state_nodal_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "state_nodal_seq", initialValue = 250, allocationSize = 1)
	private int stateNodalOfficerId;
	@Column(nullable=false)
	private String userName;
	@Column(nullable=false)
	private String password;
	@Enumerated(EnumType.STRING)
	private States state;
}
