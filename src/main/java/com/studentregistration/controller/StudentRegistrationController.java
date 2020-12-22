package com.studentregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentregistration.entity.StudentData;
import com.studentregistration.service.StudentRegistrationService;

@RestController
@CrossOrigin(value = "*")

public class StudentRegistrationController {

	@Autowired
	private StudentRegistrationService service;
	
	@GetMapping("/test")
	public String test() {
		return service.test();
	}
	
	@PostMapping("/registerstudent")
	public ResponseEntity<StudentData> addStudentData(@RequestBody StudentData data ) {
		return new ResponseEntity<StudentData>(service.addStudentData(data),HttpStatus.OK);
	}
	
	@GetMapping("/getallstudendata")
	public ResponseEntity<List<StudentData>> getAllStudentData(){
		return new ResponseEntity<List<StudentData>>(service.getAllStudentData(),HttpStatus.OK);
	}
	
	@GetMapping("/getstudentdatabyid/{id}")
	public StudentData findStudentDataById(@PathVariable int id) {
		return service.getStudentDataById(id);
	}
	
	@GetMapping("/getstudentdatabyemail/{email}")
	public StudentData findStudentDataByEmail(@PathVariable String email) {
		return service.getStudentDataByEmail(email);
	}
	
	@PutMapping("/updatestudentdata")
	public StudentData updateStudentData(@RequestBody StudentData data) {
		return service.updateStudentData(data);
	}
	
	@DeleteMapping("/deletestudentid")
	public String deleteStudentData(@PathVariable int id) {
		return service.deleteStudentDataById(id);
	}

}
