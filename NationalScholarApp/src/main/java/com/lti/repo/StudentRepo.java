package com.lti.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.dto.StudentDto;
import com.lti.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query("select s.studentId,s.studentName,s.email "
			+ "from Student s where s.email=?1 and s.password=?2")
	Student findByEmailAndPassword(String email,String password);
	@Query("select s.studentId,s.studentName,s.aadharNumber,s.dob,s.religion,s.gender,s.community"
			+ ",s.address,s.bankDetails "
			+ "from Student s where s.studentId=?1")
	StudentDto.StudentWithOutInstitute readByStudentId(int id);
}
