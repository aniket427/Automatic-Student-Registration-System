package com.project.useCases;

import java.util.Scanner;

import com.project.Dao.CourseDao;
import com.project.Dao.CourseDaoImpl;
import com.project.bean.Course;
import com.project.exceptions.CourseException;

public class AddBatchUseCase {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter course name");
		String cname = sc.next();
		
		CourseDao dao = new CourseDaoImpl();
		int lastbatch = dao.getlastbatch(cname);
		if(lastbatch==0) {
			System.out.println("This course does not exist. Please create a new course first.");
		} else {
			System.out.println("Last batch for "+ cname + " course was " + lastbatch +".");
			System.out.println("New batch number "+ (lastbatch+1) + " for "+ cname +" will be created.");
			
			int batch = lastbatch+1;
			
			System.out.println("Enter fee for this batch");
			int fee = sc.nextInt();
			
			System.out.println("Enter total number of seats");
			int totalseats = sc.nextInt();
			
			
			Course course = new Course();
			course.setCname(cname);
			course.setBatch(batch);
			course.setFee(fee);
			course.setTotalseats(totalseats);
			  
			String result="Batch addition failed";
			try {
				result = dao.addBatch(course);
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(result);

		}
		
	}

}
