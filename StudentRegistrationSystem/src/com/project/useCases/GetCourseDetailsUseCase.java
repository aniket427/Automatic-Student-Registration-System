package com.project.useCases;

import java.util.List;
import java.util.Scanner;

import com.project.Dao.CourseDao;
import com.project.Dao.CourseDaoImpl;
import com.project.bean.Course;

public class GetCourseDetailsUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter course name:");
		String cname = sc.next();
		
		CourseDao dao = new CourseDaoImpl();
		 
		try {
			List<Course> courseList = dao.getCourseDetails(cname);
			
			System.out.println("Following are the course details for "+cname+" batches");
			courseList.forEach(course ->{ System.out.println(course);
			System.out.println("--------------------------------------------------------------------------------");	
			});
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		

	}

}
