package com.student.student.controller;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.student.beans.student.StudentVo;
import com.student.student.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
//	Getting all Student list
	
	@RequestMapping(path = "/get/all/student",method = RequestMethod.GET)
	public List<StudentVo> getAllStudent( )
	{
		
		List<StudentVo> allStudentDetails = studentService.getAllStudentDetails();
		return allStudentDetails;
	}

//	Getting list by id 
	
	@RequestMapping(path = "/get/student/{id}")
	public StudentVo getStudentVo(@PathVariable("id") long id) {
		StudentVo std=studentService.getStudentVo(id);
		return std;
	}
       
//	adding student using postman
	
//	@PostMapping(path="/add/student")
//	public void addStudent(@RequestBody StudentVo studentVo) {
//		studentService.addStudent(studentVo);
//	}
	
	
//	adding student by one id one list will create validation
	
	@PostMapping(path="/add/students")
	public ResponseEntity<Boolean>addStudent(@RequestBody StudentVo studentVo){
		boolean information=studentService.addStudent(studentVo);
		if(information) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	

	
}




