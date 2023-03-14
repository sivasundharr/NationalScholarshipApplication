package com.lti.entity;

import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@SecondaryTables({
@SecondaryTable(name="institute_status",
pkJoinColumns= @PrimaryKeyJoinColumn(name="institute_status_id"
,referencedColumnName="institution_id"))
})
@AttributeOverrides({
	@AttributeOverride(name="createdAt",column= @Column(table="institute_status")),
	@AttributeOverride(name="updatedAt",column=@Column(table="institute_status")),
	@AttributeOverride(name="approvedByState",column = @Column(columnDefinition = "integer default 0",table="institute_status")),
	@AttributeOverride(name="approvedByMinistry",column=@Column(columnDefinition = "integer default 0",table="institute_status"))
})
public class Institute extends InstituteStatus{
	
	@Id
	@SequenceGenerator(name = "institute_seq", initialValue = 13000, allocationSize = 1)
	@GeneratedValue(generator = "institute_seq", strategy = GenerationType.SEQUENCE) 
	@Column(name="institution_id")
	private int institutionId;
	
	@Column(name="institution_code",nullable=false,unique=true)
	private String institutionCode;
	
	@Email(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
	private String officialEmail;
	@Column(nullable=false)
	private String institutionName;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private InstituteCategory institutionCategory;
	@Enumerated(EnumType.STRING)
	private States afiliatedState;
	@Size(min=6)
	private String diseCode;
	@NotNull
	private String universityOrBoardName;
	@Column(columnDefinition="boolean default false")
	private boolean approved;
	@Embedded
	private Address address;
	private String instituteEstablishmentCertificate;
	private String boardAffliationCertificate;
	@JsonIgnore
	@OneToMany(mappedBy = "institute")
	private Collection<Student> students;
}
