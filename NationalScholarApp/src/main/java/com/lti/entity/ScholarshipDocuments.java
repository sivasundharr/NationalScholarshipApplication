package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ScholarshipDocuments {
	
	@Id
	@GeneratedValue(generator = "scholar_docs_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "scholar_docs_seq",initialValue=1000 ,allocationSize = 1)
	private int scholarshipDocumentsId;
	@NotEmpty
	private String studentRecord;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="scholarshipId")
	private ScholarshipApplication scholarship;
	
}
