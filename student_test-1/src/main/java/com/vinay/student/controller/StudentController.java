package com.vinay.student.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.student.entity.Student;
import com.vinay.student.repository.StudentRepository;

@RestController
@RequestMapping("/student1")
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/student")
	public List<Student> allStudents(Student student){
		logger.info("Finding all the students in the Repository");
		if(student == null) {
			logger.error("Repository is null");
		}
			logger.debug("Quering for the records in the database");	
		return studentRepository.findAll();
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		logger.info("Adding a new student into the database");
		return studentRepository.save(student);	
	}
	
	@GetMapping("/student/{studentId}")
	public Student findStudent(@PathVariable int studentId) {
		logger.info("Find the student record by StudentID" +studentId);
		Optional<Student> student = studentRepository.findById(studentId);
		if(student.isPresent()) {
			logger.debug("returning the student record with its ID");
			return student.get();
		}
		else {
			logger.error("There is no record for the given StudentID: " +studentId);
			throw new RuntimeException("Student not found for the given id " + studentId);
		}
	}
	
	@DeleteMapping("/student/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		logger.info("deleting the student record by the given StudentID: " + studentId);
		Optional<Student> student = studentRepository.findById(studentId);
		if(student.isPresent()) {
			logger.debug("Deleting the Student record by Id");
			studentRepository.delete(student.get());
			return " student record is deleted for the given id" + studentId; 
		}else {
			logger.error("Student record not found for the given Id");
			throw new RuntimeException("Student not found for the given id " + studentId);
		}
		
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		logger.info("Updating the given student records");
		return studentRepository.save(student);
	}

}