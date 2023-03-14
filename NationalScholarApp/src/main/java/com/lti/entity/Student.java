package com.lti.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(generator = "student_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "student_seq", initialValue = 100, allocationSize = 1)
	private int studentId;
	@Column(nullable=false)
	private String studentName;
	@Past
	private LocalDate dob;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Email(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
	private String email;
	@NotEmpty
	@Size(max=12)
	private String aadharNumber;
	@Column(nullable=false)
	private String password;
	@NotEmpty
	private String community;
	@NotEmpty
	private String religion;
	@Embedded
	private Address address;
	@Embedded
	private BankDetails bankDetails;
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "institutionId")
	private Institute institute;
	@JsonIgnore
	@OneToMany(mappedBy="student",fetch=FetchType.LAZY)
	private Collection<ScholarshipApplication> scholarApplication;
}
