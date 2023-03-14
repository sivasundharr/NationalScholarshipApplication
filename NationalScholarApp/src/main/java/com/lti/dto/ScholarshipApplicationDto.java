package com.lti.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lti.entity.DisabilityStatus;
import com.lti.entity.ScholarshipDocuments;
import com.lti.entity.ScholarshipType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ScholarshipApplicationDto {
	private int scholarshipId;
	private String fatherName;
	private String motherName;
	private String fatherOccupation;
	private String motherOccupation;
	private double familyAnnualIncome;
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
	private int schType;
	private int student;
	// Response fields
	private StudentDto studentDto;
	private ScholarshipDocuments scholarshipDocuments;
	private ScholarshipType scholarshipType;
}
