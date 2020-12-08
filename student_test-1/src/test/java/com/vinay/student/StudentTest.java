package com.vinay.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.vinay.student.entity.Student;
import com.vinay.student.repository.StudentRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class StudentTest {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	@Rollback(false)
	public void testNewStudent() {
		Student student = new Student(110,"vinay","Murahari","Boxhill");
		Student newStudent = studentRepository.save(student);
		
		assertNotNull(newStudent);
	}
	
	@Test
	@Rollback(false)
	public void testForTheRecord() {
		Student student = studentRepository.save(new Student(101,"vinay","murahari","boxhill"));

		assertThat(student).hasFieldOrPropertyWithValue("studentId", 101);
		assertThat(student).hasFieldOrPropertyWithValue("studentFname", "vinay");
		assertThat(student).hasFieldOrPropertyWithValue("studentLname", "murahari");
		assertThat(student).hasFieldOrPropertyWithValue("studentAdress", "boxhill");
		
	}

	@Test
    public void testDeleteStudent() {
		Student student = new Student(1,"vinay","vinay","Boxhill");
		studentRepository.save(student);
        studentRepository.delete(student);
    }
	@Test
    public void testFindAllStudents() {

		Student student = new Student(1,"vinay","vinay","Boxhill");
		studentRepository.save(student);
        assertNotNull(studentRepository.findAll());
    }
	@Test
	public void testDeletById() {
		Student student = new Student(1,"vinay","vinay","Boxhill");
		studentRepository.save(student);
		studentRepository.deleteById(student.getStudentId());
	}
	
	
}
 