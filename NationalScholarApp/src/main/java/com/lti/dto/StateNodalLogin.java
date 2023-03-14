package com.lti.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StateNodalLogin {
	private int stateNodalOfficerId;
	private String name;
	private String password;
}
