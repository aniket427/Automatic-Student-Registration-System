package com.project.useCases;

import java.util.List;

import com.project.Dao.CourseDao;
import com.project.Dao.CourseDaoImpl;
import com.project.bean.Course;
import com.project.bean.StudentDTO;

public class GetBatchwiseStudentsUseCase {

	public static void main(String[] args) {
		
		
		CourseDao dao = new CourseDaoImpl();
		 
		try {
			List<StudentDTO> coursewiseStudentList = dao.getBatchwiseStudents();
			
			System.out.println("Following are the course and batchwise student details");
			System.out.println("--------------------------------------------------------------------------------");
			
			coursewiseStudentList.forEach(student ->{ System.out.println(student);
			System.out.println("--------------------------------------------------------------------------------");	
			});
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		


	}

}
