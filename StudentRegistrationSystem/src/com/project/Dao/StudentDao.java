package com.project.Dao;

import java.util.List;

import com.project.bean.Student;
import com.project.exceptions.StudentException;

public interface StudentDao {

	
		public String registerStudent(Student student);
		
		public Student loginStudent(String username, String password)throws StudentException;
		
		public String updateStudent(Student student);
		
		public Student getStudentObj();
		
		public List<Student> getAllStudents() throws StudentException;
		
		
}
