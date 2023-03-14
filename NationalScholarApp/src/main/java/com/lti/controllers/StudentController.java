package com.lti.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lti.dto.LoginDto;
import com.lti.dto.LoginResponseDto;
import com.lti.dto.StudentDto;
import com.lti.exception.ResourceNotFoundException;
import com.lti.service.StudentService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/student")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService){
		this.studentService = studentService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> searchByStudentId(@PathVariable("id") int id) {

		var student = studentService.searchByStudentId(id);
		if (student == null) {

			throw new ResourceNotFoundException("student not found : " + id);

		}
		return new ResponseEntity<>(student, HttpStatus.ACCEPTED);

	}


	@PostMapping
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDto.StudentOnly student) {
		StudentDto.StudentOnly newStudent = studentService.createStudent(student);
		if (newStudent != null) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newStudent.getStudentId()).toUri();

			return ResponseEntity.created(uri).build();
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
		StudentDto.StudentOnly newStudent = studentService.login(loginDto.getUserName(), loginDto.getPassword());
		if (newStudent != null) {
			LoginResponseDto loginResponse = new LoginResponseDto();

			loginResponse.setId(newStudent.getStudentId());
			loginResponse.setName(newStudent.getStudentName());

			return new ResponseEntity<LoginResponseDto>(loginResponse, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}


	@PutMapping("/{id}")
	public StudentDto.StudentOnly updateStudent(@PathVariable int id, 
			@Valid @RequestBody StudentDto.StudentOnly studentDto) {
		return studentService.updateStudent(id, studentDto);
	}
}
