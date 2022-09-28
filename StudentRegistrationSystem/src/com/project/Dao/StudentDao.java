package com.project.Dao;

import com.project.bean.Student;
import com.project.exceptions.StudentException;

public interface StudentDao {

	
		public String registerStudent(Student student);
		
		public Student loginStudent(String username, String password)throws StudentException;
		
		public String updateStudent(Student student);
		
		
		
}
