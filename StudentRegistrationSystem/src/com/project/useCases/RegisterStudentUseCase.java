package com.project.useCases;

import java.util.Scanner;

import com.project.Dao.StudentDao;
import com.project.Dao.StudentDaoImpl;
import com.project.bean.Student;

public class RegisterStudentUseCase {

		public static void main(String[] args) {
			
			Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter student name");
			String sname = sc.next();
			
			System.out.println("Enter student email");
			String email = sc.next();
			
			System.out.println("Enter student password");
			String pass = sc.next();
			
			System.out.println("Enter course name the student wants to opt in");
			String cname = sc.next();
			
			
			StudentDao dao = new StudentDaoImpl();
			
			Student student = new Student();
			student.setName(sname);
			student.setEmail(email);
			student.setPassword(pass);
			student.setCourse(cname);
			
			  
			String result = dao.registerStudent(student);
			
			System.out.println(result);
		}
	
}
