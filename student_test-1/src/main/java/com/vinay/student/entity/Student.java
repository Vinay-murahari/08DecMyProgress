package com.vinay.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
		@Id
		@Column(name="student_id")
		public int studentId;
		@Column(name="student_fname")
		public String studentFname;
		@Column(name="student_lname")
		public String studentLname;
		@Column(name="student_adress")
		public String studentAdress;
		
		public Student() {
			
		}
		public Student(int studentId, String studentFname, String studentLname, String studentAdress) {
			super();
			this.studentId = studentId;
			this.studentFname = studentFname;
			this.studentLname = studentLname;
			this.studentAdress = studentAdress;
		}
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public String getStudentFname() {
			return studentFname;
		}
		public void setStudentFname(String studentFname) {
			this.studentFname = studentFname;
		}
		public String getStudentLname() {
			return studentLname;
		}
		public void setStudentLname(String studentLname) {
			this.studentLname = studentLname;
		}
		public String getStudentAdress() {
			return studentAdress;
		}
		public void setStudentAdress(String studentAdress) {
			this.studentAdress = studentAdress;
		}
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentFname=" + studentFname + ", studentLname="
					+ studentLname + ", studentAdress=" + studentAdress + "]";
		}
		
		
}