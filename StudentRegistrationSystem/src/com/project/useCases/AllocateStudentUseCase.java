package com.project.useCases;

import java.util.List;
import java.util.Scanner;

import com.project.Dao.CourseDao;
import com.project.Dao.CourseDaoImpl;
import com.project.Dao.StudentDao;
import com.project.Dao.StudentDaoImpl;
import com.project.bean.Course;
import com.project.bean.Student;

public class AllocateStudentUseCase {

	public static void main(String[] args) {
		
	

		
		
		
				
//		To get list of all available students
		
		StudentDao stdao = new StudentDaoImpl();
		 
		try {
			List<Student> studentList = stdao.getAllStudents();
			
			System.out.println("Following is the list of all students:");
			System.out.println("================================================================================");
			studentList.forEach(student ->{ System.out.println("Student roll no: "+student.getRoll()+" Student name: "+student.getName());
			System.out.println("--------------------------------------------------------------------------------");	
			});
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		

//		To get list of all available courses
			
		
		CourseDao dao = new CourseDaoImpl();
		
		 
		try {
			List<Course> courseList = dao.getAllCourses();
			System.out.println();
			System.out.println("Following are the all courses and batches available:");
			System.out.println("================================================================================");
			courseList.forEach(course ->{ System.out.println("Course ID: "+course.getCid()+" Course Name: "+course.getCname()+" Batch: "+course.getBatch());
			System.out.println("--------------------------------------------------------------------------------");	
			});
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		
//To add allocate student
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Student roll number to allocate course");
		int roll= sc.nextInt();
		
		System.out.println("Enter the Course ID");
		int cid= sc.nextInt();
		
		
		try {
		String result = dao.allocateStudent(roll, cid);
		
		System.out.println(result);
		
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
