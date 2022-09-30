package com.project.useCases;

import java.util.Scanner;

import com.project.Dao.CourseDao;
import com.project.Dao.CourseDaoImpl;
import com.project.exceptions.CourseException;

public class UpdateTotalSeatsUseCase {

	public static void main(String[] args)  {
		
		String result = "Update failed";
			
			Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter course name: ");
			
			String cname=sc.next();
			
			System.out.println("Enter batch number: ");
			
			int batch = sc.nextInt();
			
			System.out.println("Enter the new number of total seats: ");
			
			int seats = sc.nextInt();
			
			CourseDao dao = new CourseDaoImpl();
			
			
			try {
				result = dao.updateTotalSeats(cname, batch, seats);
			} catch (CourseException e) {
				
				e.getMessage();
			}
			
			
			System.out.println(result);
		}

	}


