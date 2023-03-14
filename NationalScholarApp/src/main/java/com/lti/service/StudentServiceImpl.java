package com.lti.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.StudentDto;
import com.lti.entity.Student;
import com.lti.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private InstituteService instituteService;
	
	@Override
	public Student getById(int id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public StudentDto.StudentWithOutInstitute getByStudentId(int id){
		var student = studentRepo.readByStudentId(id);
		
	
		TypeMap<StudentDto.StudentWithOutInstitute,StudentDto.StudentWithOutInstituteDto> tMap= modelMapper.getTypeMap(
				StudentDto.StudentWithOutInstitute.class,StudentDto.StudentWithOutInstituteDto.class);
		if(tMap==null) {
		
			tMap = modelMapper.createTypeMap( StudentDto.StudentWithOutInstitute.class,StudentDto.StudentWithOutInstituteDto.class);
			
		}
		var sDto = modelMapper.map(student,
				StudentDto.StudentWithOutInstituteDto.class);
			System.out.println(sDto);
		return null;
		
	}
	
	@Override
	public StudentDto.StudentOnly login(String email,String password) {
		Student student = studentRepo.findByEmailAndPassword(email, password);
		if(student!=null)
			return convertToStudentDto(student);
		return null;
	}
	@Override
	public StudentDto.StudentWithOutInstitute searchByStudentId(int id) {
		return getByStudentId(id);
	}
	
	@Override
	public StudentDto.StudentOnly createStudent( StudentDto.StudentOnly studentDto) {
		Student student = studentRepo.save(
				convertStudentDtoToStudent(studentDto));
		return convertToStudentDto(student);
		
	}
	@Override
	public StudentDto.StudentOnly updateStudent(int id,StudentDto.StudentOnly studentDto) {
		Student student = getById(id);
		if(student!=null) {
			studentDto.setStudentId(student.getStudentId());
			Student s = studentRepo.save(student);
			return convertToStudentDto(s);
		}
		return createStudent(studentDto);
	}
	
	// Mapping methods
	
	@Override
	public Student convertStudentDtoToStudent(StudentDto.StudentOnly studentDto) {
		var i = instituteService.getById(studentDto.getInstitute());
		TypeMap<StudentDto.StudentOnly,Student> tMap= modelMapper.getTypeMap(StudentDto.StudentOnly.class,
				Student.class);
		if(tMap==null) {
		
			tMap = modelMapper.createTypeMap(StudentDto.StudentOnly.class, Student.class);
			tMap.addMappings(m->m.map(
				s-> i
			, Student::setInstitute));
		}
		return modelMapper.map(studentDto,Student.class);
	}
	
	@Override
	public StudentDto.StudentOnly convertToStudentDto(Student student) {
		TypeMap<Student,StudentDto.StudentOnly> tMap= modelMapper.getTypeMap(Student.class,
				StudentDto.StudentOnly.class);
		if(tMap==null) {
			var i = student.getInstitute();
			tMap = modelMapper.createTypeMap(Student.class, StudentDto.StudentOnly.class);
			
			tMap.addMapping(m->i.getInstitutionId(), StudentDto.StudentOnly::setInstitute);
			//skip elements
			tMap.addMappings(m->m.skip(StudentDto.StudentOnly::setPassword));
		
		}
		return modelMapper.map(student,StudentDto.StudentOnly.class);
	}
	

	public StudentDto.StudentOnly convertToStudentDto2(Student student) {
		TypeMap<Student,StudentDto.StudentOnly> tMap= modelMapper.getTypeMap(Student.class,
				StudentDto.StudentOnly.class);
		if(tMap==null) {
			tMap = modelMapper.createTypeMap(Student.class, StudentDto.StudentOnly.class);
			tMap.addMappings(m->m.skip( StudentDto.StudentOnly::setInstitute));
			tMap.addMappings(m->m.skip(StudentDto.StudentOnly::setPassword));
		}
		return modelMapper.map(student,StudentDto.StudentOnly.class);
	}
	
}
