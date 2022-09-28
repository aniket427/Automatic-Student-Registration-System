package com.project.utility;

import java.sql.Connection;
import java.util.Scanner;

import com.project.useCases.RegisterStudentUseCase;
import com.project.useCases.StudentLoginUseCase;
import com.project.useCases.UpdateStudentUseCase;

public class Demo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("0 register");
			System.out.println("1 login");
			System.out.println("2 update details");
			System.out.println("Enter choice");
			
			
			int choice = sc.nextInt();
			
			if (choice==0) {
				RegisterStudentUseCase.main(null);
			}
			
			if(choice==1) {
				StudentLoginUseCase.main(null);
			} 
			if(choice==2) {
				UpdateStudentUseCase.main(null);
			}
		}
		
		
		
	}

}
