package com.main;

import java.util.Scanner;

import com.project.useCases.RegisterStudentUseCase;
import com.project.useCases.StudentLoginUseCase;
import com.project.useCases.UpdateStudentUseCase;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***   Welcome to Student Registration System   ***");
		System.out.println("=====================================================");
		
		System.out.println("Please select one of the following user types:");
		System.out.println("1. Administrator");
		System.out.println("2. Student");
		System.out.println("3. Exit");
		
		int userSelect = sc.nextInt();
		
		
		while (userSelect!=3) {
			if (userSelect == 1) {
				
			} else if (userSelect ==2) {
				
				
				
					System.out.println("1 Login");
					System.out.println("2 New User? Register");
					System.out.println("3 Show all courses and availability");
					System.out.println("4 Exit");
					System.out.println("Enter choice:");
					
					int choice = sc.nextInt();
					
					if (choice==1) {
						StudentLoginUseCase.main(null);
						
					} else if(choice==2) {
						RegisterStudentUseCase.main(null);
					} else if(choice==3){
						
						
//						Show all batches information
						
						
					} else if(choice==4){
						System.out.println("Thank you!");
						userSelect = 3;
					} else {
						System.out.println("Invalid selection. Please try again.");
						System.out.println();
					}
						
						
				
			} else if(userSelect==3){
				System.out.println("Thank you!");
			} else {
				System.out.println("Invalid selection");
			}
			
		}
	
	}

}
