package com.lti.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class BankDetails implements Serializable {
	public BankDetails() {
	}
	@Size(max=16)
	@NotEmpty
	private String accountNo;
	@NotEmpty
	private String holderName;
	@NotEmpty
	private String ifscCode;
}
