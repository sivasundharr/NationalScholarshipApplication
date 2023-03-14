package com.lti.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.lti.entity.Address;
import com.lti.entity.BankDetails;
import com.lti.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class StudentDto {
	
	@Data
	public static class StudentOnly{
		private int studentId;
		@NotEmpty(message="name must not be empty or null")
		private String studentName;
		@Past
		private LocalDate dob;
		@Enumerated(EnumType.STRING)
		private Gender gender;
		@Email(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
		private String email;
		@NotEmpty
		@Size(min=12,max=12,message="size must be 12")
		private String aadharNumber;
		@NotEmpty
		@Size(min=8,max=15,message="Password must be within 8 to 15 characters")
		private String password;
		@NotEmpty
		private String community;
		@NotEmpty
		private String religion;
		private BankDetails bankDetails;
		private Address address;
		private int institute;
	}
	
	@Data
	public static class StudentWithInstitute{
		private int studentId;
		private String studentName;
		private LocalDate dob;
		@Enumerated(EnumType.STRING)
		private Gender gender;
		private String aadharNumber;
		private String community;
		private String religion;
		private BankDetails bankDetails;
		private Address address;
		private InstituteDto instituteDto;
	}
	
	
	public interface StudentWithOutInstitute{
		 int getStudentId();
		 String getStudentName();
		 LocalDate getDob();
		 String getGender();
		 String getAadharNumber();
		 String getCommunity();
		 String getReligion();
		 BankDetails getBankDetails();
		 Address getAddress();
	}
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class StudentWithOutInstituteDto{
		private int studentId;
		private String studentName;
		 private LocalDate dob;
		 private String gender;
		private String aadharNumber;
		private String community;
		private String religion;
		private BankDetails bankDetails;
		private Address address;
	}
}
