package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@SecondaryTable(name="scholarship_status",pkJoinColumns=
@PrimaryKeyJoinColumn(name="sch_status_id"
,referencedColumnName="scholarship_id"))
@AttributeOverrides({
@AttributeOverride(name="createdAt",column=@Column(table="scholarship_status")),
@AttributeOverride(name="updatedAt",column=@Column(table="scholarship_status")),
@AttributeOverride(name="approvedByInstitute",column=@Column(columnDefinition = "integer default 0",table="scholarship_status")),
@AttributeOverride(name="approvedByState",column=@Column(columnDefinition = "integer default 0",table="scholarship_status")),
@AttributeOverride(name="approvedByMinistry",column=@Column(columnDefinition = "integer default 0",table="scholarship_status"))
})
public class ScholarshipApplication extends ScholarshipStatus {
	
	@Id
	@GeneratedValue(generator = "scholarship_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "scholarship_seq", initialValue = 12500, allocationSize = 1)
	@Column(name="scholarship_id")
	private int scholarshipId;
	@NotEmpty
	private String fatherName;
	private String motherName;
	private String fatherOccupation;
	private String motherOccupation;
	@Column(nullable=false)
	private double familyAnnualIncome;
	@NotEmpty
	private String presentCourse;
	private String presentCourseYear;
	private String modeOfStudy;
	private LocalDate startDate;
	private String previouseCourse;
	private int currentYear;
	private double previouseCoursePer;
	private String rollNumber_10;
	private String boardName_10;
	private int passedYear_10;
	private double percent_10;
	private String rollNumber_12;
	private String boardName_12;
	private int passedYear_12;
	private double percent_12;
	private double addmissionFee;
	private double tutionFee;
	private double otherFee;
	private boolean isDisabled;
	@Enumerated(EnumType.STRING)
	private DisabilityStatus disabilityStatus;
	private double percentOfDisability;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name = "scholarshipTypeId")
	private ScholarshipType schType;
	@OneToOne(mappedBy = "scholarship")
	private ScholarshipDocuments scholarshipDocuments;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	private Student student;
}
