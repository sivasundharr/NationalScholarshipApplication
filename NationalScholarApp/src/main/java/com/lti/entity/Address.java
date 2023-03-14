package com.lti.entity;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	@NotNull
	@Size(min=2,max=255,message="Invalid address line")
	private String addressLine;
	@NotNull
	private String city;
	@Enumerated(EnumType.STRING)
	private States state;
	@NotNull
	@Size(min=6,max=6,message="Pincode must be only 6 digits")
	private String pincode;
}
