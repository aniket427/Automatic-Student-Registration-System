package com.project.useCases;

import java.util.Scanner;

import com.project.Dao.StudentDao;
import com.project.Dao.StudentDaoImpl;
import com.project.bean.Student;

public class UpdateStudentUseCase {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoImpl();
		
		Student student = new Student();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Do you wish to update your name? y/n");
		
		String updateName=sc.next();
		
		if(updateName.equalsIgnoreCase("y")) {
			
			System.out.println("Enter updated name");
			
			String sname = sc.next();
			student.setName(sname);
			
		} else {
			sc.nextLine();
		}
		
		

		System.out.println("Enter updated password");
		String pass = sc.next();
		
		
		System.out.println("Enter new course you wish to opt in");
		String cname = sc.next();
		
		
		
		
		
		student.setPassword(pass);
		student.setCourse(cname);
		
		  
		String result = dao.updateStudent(student);
		
		System.out.println(result);
	}

}


