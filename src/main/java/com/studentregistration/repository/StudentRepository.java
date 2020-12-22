package com.studentregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentregistration.entity.StudentData;

public interface StudentRepository extends JpaRepository<StudentData,Integer>{

	StudentData findByEmailId(String emailId);

}
