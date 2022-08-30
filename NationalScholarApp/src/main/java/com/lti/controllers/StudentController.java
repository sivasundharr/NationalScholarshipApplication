package com.lti.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.lti.dto.LoginDto;
import com.lti.entity.ScholarshipStatus;
import com.lti.entity.Student;
import com.lti.service.ScholarshipStatusService;
import com.lti.service.StudentService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
//	@Autowired
//	private StudentService studentService;
//	//
	@Autowired
	private ScholarshipStatusService schStatusService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> searchByStudentId(@PathVariable("id") int id) {
		
		 Optional<Student> student = 	studentService.searchByStudentId(id);
		 if(student.isPresent()) {
			 return new ResponseEntity<Student>(student.get(),HttpStatus.OK);
		 }
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	}
	
	@GetMapping("/contact/{email}")
	public ResponseEntity<?> searchStudentByEmail(@PathVariable("email") String email){
		 Student student = 	studentService.searchByStudentEmail(email);
		 if(student!=null) {
			 return new ResponseEntity<Student>(student,HttpStatus.OK);
		 }
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody LoginDto loginDto){
		if(studentService.login(loginDto.getEmail(),loginDto.getPassword())) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/application/{studentId}")
	public ResponseEntity<?> showScholarshipStatusByStudentId(int studentId) {
		ScholarshipStatus Ss =  schStatusService.getScholarshipStatusByStudentId(studentId);
		if(Ss!=null) {
			return new ResponseEntity<ScholarshipStatus>(Ss,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id,@RequestBody Student student) {
		return studentService.updateStudent(id,student);
	}
}
