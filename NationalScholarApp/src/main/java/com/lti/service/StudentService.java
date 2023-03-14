package com.lti.service;

import org.springframework.stereotype.Component;

import com.lti.dto.StudentDto;
import com.lti.entity.Student;

@Component
public interface StudentService {
	StudentDto.StudentOnly login(String email,String password);
	Student getById(int id);
	StudentDto.StudentWithOutInstitute searchByStudentId(int id);
	StudentDto.StudentOnly createStudent(StudentDto.StudentOnly sDto);
	StudentDto.StudentOnly updateStudent(int id,StudentDto.StudentOnly sDto);
	
	Student convertStudentDtoToStudent(StudentDto.StudentOnly studentDto);
	StudentDto.StudentOnly convertToStudentDto(Student student);
}
