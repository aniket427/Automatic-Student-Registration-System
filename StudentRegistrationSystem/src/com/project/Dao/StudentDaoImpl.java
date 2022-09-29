package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Course;
import com.project.bean.Student;
import com.project.exceptions.CourseException;
import com.project.exceptions.StudentException;
import com.project.utility.DBUtil;

public class StudentDaoImpl implements StudentDao{
	
	static int studentloggedin;

	@Override
	public String registerStudent(Student student) {

		String message = "Registration failed";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
			conn.prepareStatement("insert into student(name,email,password,coursename) values(?,?,?,?)");
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getPassword());
			ps.setString(4, student.getCourse());
			
			int x = ps.executeUpdate();
			
			if (x>0) {
				
				message = "Student registration successful."; 	
				
			}
			
		} catch (SQLException e) {
			
			message=e.getMessage();
			
		}
		
		
		
		return message;
	}

	@Override
	public String updateStudent(Student student) {
		String message = "Update failed";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = 
					conn.prepareStatement("UPDATE student SET name = ? , password = ? , coursename = ? where roll = ?");

			ps.setString(1, student.getName());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getCourse());
			ps.setInt(4, studentloggedin);
			
			int x = ps.executeUpdate();
			
			if (x>0) {
				
				message = "Student details updated successfully."; 	
				
			}
			
				
		} catch (SQLException e) {
			 
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public Student loginStudent(String username, String password) throws StudentException {
			
		Student student = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from student where email = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				int r= rs.getInt("roll");
				String n= rs.getString("name");
				String e= rs.getString("email");
				String p= rs.getString("password");
				String c = rs.getString("coursename");
				
				studentloggedin = r;
				
			student=new Student(r, n, e, p, c);	
				
				
			}else
				throw new StudentException("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return student;
		
	}

	@Override
	public Student getStudentObj() {

		Student student = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from student where roll = ?");			
			
			ps.setInt(1, studentloggedin);
			
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				int r = rs.getInt("roll");
				String n= rs.getString("name");
				String e= rs.getString("email");
				String p= rs.getString("password");
				String c = rs.getString("coursename");
				
				
			student=new Student(r, n, e, p, c);	
			
		}
				
		}catch (SQLException e) {
			
			student = null;
		}
		
		return student;
		
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		List<Student> studentList = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from student");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int roll = rs.getInt("roll");
				String n = rs.getString("name");
				
				
				Student student = new Student();
				student.setName(n);
				student.setRoll(roll);
				
				studentList.add(student);
			
			}
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		if (studentList.isEmpty()) {
			throw new StudentException("No student data found");
		}
		
		return studentList;
		
	}


	
}
