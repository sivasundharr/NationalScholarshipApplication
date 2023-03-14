package com.lti.dto;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lti.entity.Address;
import com.lti.entity.InstituteCategory;
import com.lti.entity.States;

import lombok.Data;

@Data
public class InstituteDto {
	
	private int institutionId;
	@NotEmpty
	private String institutionCode;
	@Email(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
	private String officialEmail;
	@NotEmpty
	private String institutionName;
	@NotEmpty
	private String password;
	@Enumerated(EnumType.STRING)
	private InstituteCategory institutionCategory; 
	@Enumerated(EnumType.STRING)
	private States afiliatedState;
	@Size(min=6)
	private String diseCode;
	@NotEmpty
	private String universityOrBoardName;
	private boolean approved;
	private Address address;
	@NotEmpty
	private String instituteEstablishmentCertificate;
	@NotEmpty
	private String boardAffliationCertificate;
	private int approvedByState;
	private int approvedByMinistry;
	private Date createdAt;
    private LocalDateTime updatedAt;
}
