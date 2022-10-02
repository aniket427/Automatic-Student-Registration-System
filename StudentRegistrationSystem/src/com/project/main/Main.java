package com.project.main;

import java.util.Scanner;



import com.project.useCases.AddBatchUseCase;
import com.project.useCases.AddCourseUseCase;
import com.project.useCases.AdminLoginUseCase;
import com.project.useCases.AllocateStudentUseCase;
import com.project.useCases.DeleteCourseUseCase;
import com.project.useCases.GetBatchwiseStudentsUseCase;
import com.project.useCases.GetCourseDetailsUseCase;
import com.project.useCases.GetSeatAvailabilityUseCase;
import com.project.useCases.RegisterStudentUseCase;
import com.project.useCases.StudentLoginUseCase;
import com.project.useCases.UpdateTotalSeatsUseCase;
import com.project.useCases.UpdateCourseFee;
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
				
				System.out.println("1 Login");
				System.out.println("2 Exit");
				
				int choice = sc.nextInt();
				
				if (choice==1) {
					if(AdminLoginUseCase.main(null)==true) {
						
						while(userSelect!=3) {
							System.out.println();
							System.out.println("--------------------------------------------------------------");
							System.out.println("Please select one of the following options");
							System.out.println("1. Add a new Course");
							System.out.println("2. Update Fees of course");
							System.out.println("3. Delete  a course or batch");
							System.out.println("4. Search information about a course");
							System.out.println("5. Create Batch under a course");
							System.out.println("6. Allocate students in a Batch under a course");
							System.out.println("7. Update total seats of a batch");
							System.out.println("8. View the students of every batch");
							System.out.println("9. Exit");
							
							int x = sc.nextInt();
							
							
							switch (x) {
							
							case 1: AddCourseUseCase.main(null);
								
								break;
							
							case 2: UpdateCourseFee.main(null);
							
								break;
								
							case 3: DeleteCourseUseCase.main(null);
								
								break;
								
							case 4: GetCourseDetailsUseCase.main(null);
							
								break;
								
							case 5: AddBatchUseCase.main(null);
							
								break;
								
							case 6: AllocateStudentUseCase.main(null);
							
								break;
							
							case 7: UpdateTotalSeatsUseCase.main(null);
								
								break;
								
							case 8: GetBatchwiseStudentsUseCase.main(null);
							
								break;
								
							case 9: userSelect = 3;
									System.out.println("Thank you!");
								break;
								
							default: System.out.println("Invalid Selection..");
								break;
							}
							

						}
						
												
						
					} else {
						System.out.println("Login failed. Please try again..");
					}
					
				} else if(choice==2){
					System.out.println("Thank you!");
					userSelect = 3;
				} else {
					System.out.println("Invalid selection. Please try again.");
					System.out.println();
				}
				
				
				
			} else if (userSelect ==2) {
				
				
				while(userSelect!=3) {
					
					System.out.println("1 Login");
					System.out.println("2 New User? Register");
					System.out.println("3 Exit");
					System.out.println("Enter choice:");
					
					
					int choice = sc.nextInt();
					
					
					if (choice==1) {
						
						while(userSelect!=3) {
							
							if(StudentLoginUseCase.main(null)==true) {
								
								while(userSelect!=3){
									System.out.println("Please select one of the options below");
									System.out.println("---------------------------------------");
									System.out.println("1. Update profile details");
									System.out.println("2. Show all courses and availability");
									System.out.println("3. Exit");
									
									int y = sc.nextInt();
									
									switch (y) {
									case 1: UpdateStudentUseCase.main(null);
										
										break;

									case 2: GetSeatAvailabilityUseCase.main(null);
										break;
										
									case 3: userSelect=3;
											System.out.println("Thank you!");
										break;
									
									default: System.out.println("Invalid selection");
										break;
									}
								}
								
								
							} 
							
						}
					
					} else if(choice==2) {
						
						RegisterStudentUseCase.main(null);
						
					}  else if(choice==3){
						
						System.out.println("Thank you!");
						userSelect = 3;
						
					} else {
						
						System.out.println("Invalid selection. Please try again.");
						System.out.println();
						
					}
					
				}
					
						
						
				
			} else if(userSelect==3){
				System.out.println("Thank you!");
			} else {
				System.out.println("Invalid selection");
			}
			
		}
	
	}

}
