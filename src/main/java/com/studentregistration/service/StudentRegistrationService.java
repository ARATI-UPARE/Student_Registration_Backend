package com.studentregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentregistration.entity.StudentData;
import com.studentregistration.repository.StudentRepository;

@Service
public class StudentRegistrationService {
	
	@Autowired
	private StudentRepository repository;
	
	public String test() {
		return "Welcome";
	}
	
	public StudentData addStudentData( StudentData data) {
		System.out.println("You are registered successfully");
		return repository.save(data);
	}
	
	public List<StudentData> getAllStudentData(){
		return repository.findAll();
	}
	
	public StudentData getStudentDataById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public StudentData getStudentDataByEmail(String email) {
		return repository.findByEmailId(email);
	}
	
	public String deleteStudentDataById(int id) {
		repository.deleteById(id);
		return "Student Data Removed of "+id;
	}
	
	public StudentData updateStudentData(StudentData student) {
		StudentData existingStudent = repository.findById(student.getId()).orElse(null);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmailId(student.getEmailId());
		existingStudent.setMobileNumber(student.getMobileNumber());
		return repository.save(existingStudent);

	}

}
