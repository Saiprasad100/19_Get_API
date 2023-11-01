package com.numetry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.entity.Student;
import com.numetry.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/Studentget")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudents();

	}

	@PostMapping("/Studentsave")
	public Student createStudent(@RequestBody Student student) {
		return studentservice.saveStudent(student);

	}

	@PutMapping("/UpdatedById/{id}")
	public Student updateStudent(@PathVariable Integer id,@RequestBody Student student)  {
		return studentservice.updatedStudent(id,student);

	}
}
