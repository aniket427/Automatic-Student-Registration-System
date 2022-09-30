package com.project.useCases;

import java.util.Scanner;

import com.project.Dao.AdminDao;
import com.project.Dao.AdminDaoImpl;


public class AdminLoginUseCase {

	public static boolean main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter administrator username:");
		String uname = sc.next();
		
		System.out.println("Enter administrator password:");
		String pass = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		if(dao.adminLogin(uname, pass)==true) {
			return true;
		} else {
			return false;
		}
		

	}

}
