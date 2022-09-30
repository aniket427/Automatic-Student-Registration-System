package com.project.useCases;

import java.util.List;

import com.project.Dao.CourseDao;
import com.project.Dao.CourseDaoImpl;
import com.project.bean.Course;
import com.project.bean.CourseDTO;

public class GetSeatAvailabilityUseCase {

	public static void main(String[] args) {
		
		CourseDao dao = new CourseDaoImpl();
		 
		try {
			List<CourseDTO> courseList = dao.seatAvailability();     
			
			System.out.println("Following are the courses running with seat availability");
			courseList.forEach(course ->{ System.out.println(course);
			System.out.println("--------------------------------------------------------------------------------");	
			});
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		


	}

}
