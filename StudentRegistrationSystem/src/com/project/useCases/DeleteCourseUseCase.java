package com.project.useCases;

import java.util.Scanner;

import com.project.Dao.CourseDao;
import com.project.Dao.CourseDaoImpl;

public class DeleteCourseUseCase {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter course name: ");
		
		String cname=sc.next();
		
		System.out.println("Enter batch number: ");
		
		int batch = sc.nextInt();
		
		
		CourseDao dao = new CourseDaoImpl();
		
		String result = dao.deleteCourse(cname, batch);
		System.out.println(result);


	}

}
