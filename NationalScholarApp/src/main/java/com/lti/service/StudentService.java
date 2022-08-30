package com.lti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Student;
import com.lti.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private InstituteService instituteService;
	
	public boolean login(String email,String password) {
		Student stud = studentRepo.findEmailPasswordEqulas(email, password);
		if(stud != null) {
			return true;
		}
		return false;
	}
	
	public Optional<Student> searchByStudentId(int id) {
		return studentRepo.findById(id);
	}
	
	public Student searchByStudentEmail(String email){
		return studentRepo.findByEmail(email);
	}
	
	public Student createStudent( Student student) {
		student.setInstitute(instituteService.findById(
				student.getCollegeId()).get());
		return studentRepo.save(student);
	}
	
	public Student updateStudent(int id,Student student) {
		Optional<Student> stud = searchByStudentId(id);
		if(stud.isPresent()) {
			return studentRepo.save(student);
		}
		return createStudent(student);
	}

}
