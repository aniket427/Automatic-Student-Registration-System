package com.project.useCases;

import java.util.Scanner;

import com.project.Dao.StudentDao;
import com.project.Dao.StudentDaoImpl;
import com.project.bean.Student;

public class UpdateStudentUseCase {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoImpl();
		
		Student student = dao.getStudentObj();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Do you wish to update your name? y/n");
		
		String updateName=sc.next();
		
		if(updateName.equalsIgnoreCase("y")) {
			
			System.out.println("Enter new name");
			
			String sname = sc.next();
			student.setName(sname);
			
		} 
		
		System.out.println("Do you want to update your password? y/n");
		
		String updatePass=sc.next();
		
		if(updatePass.equalsIgnoreCase("y")) {
			
			System.out.println("Enter new name");
			
			String pass = sc.next();
			student.setPassword(pass);
			
		} 
		
		System.out.println("Do you want to update your course? y/n");
		
		String updateCourse=sc.next();
		
		if(updateCourse.equalsIgnoreCase("y")) {
			
			System.out.println("Enter new course name:");
			
			String course = sc.next();
			student.setCourse(course);
			
		} 
		
		  
		String result = dao.updateStudent(student);
		
		System.out.println(result);
	}

}


