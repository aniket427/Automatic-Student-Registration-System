package com.project.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Course;
import com.project.bean.CourseDTO;
import com.project.bean.Student;
import com.project.bean.StudentDTO;
import com.project.exceptions.CourseException;
import com.project.exceptions.StudentException;
import com.project.utility.DBUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public String addCourse(Course course) {

		String message = "Course addition failed.";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("insert into course(cname,batch,fee,totalseats) values(?,?,?,?)");
					
			ps.setString(1, course.getCname());
			ps.setInt(2, course.getBatch());
			ps.setInt(3, course.getFee());
			ps.setInt(4, course.getTotalseats());
			
			
			int x = ps.executeUpdate();
			
			if (x>0) {
				
				message = "Course added successfully."; 	
				
			}
		} catch (SQLException e) {
			
			message=e.getMessage();
		}
				
				
		return message;
	}

	@Override
	public int getlastbatch(String cname) {
		
		int lastbatch = 0;
		
		try (Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select count(*) from course where cname=?");
			
			
			ps.setString(1, cname);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				lastbatch = rs.getInt("count(*)");
					
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			
		}
		
		
		return lastbatch;
	}

	@Override
	public String updateFee(String cname, int batch, int fee) {
		String message = "Batch "+ batch +" for "+cname+" course not found.";
		
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("UPDATE course SET fee = ? where cname = ? AND batch = ?");
					
				ps.setInt(1, fee);
				ps.setString(2, cname);
				ps.setInt(3, batch);
				
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Course fee for "+cname+" course "+batch+" batch has been updated";
			}
					
			
		} catch (SQLException e) {
			e.getMessage();
		}
			
		return message;
	}
	

	@Override
	public String deleteCourse(String cname, int batch) {
		
		String message = "Batch "+ batch +" for "+cname+" course not found.";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("DELETE FROM course where cname = ? AND batch = ?");
					
			
				ps.setString(1, cname);
				ps.setInt(2, batch);
				
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Course "+cname+" batch "+batch+" has been deleted";
			}
					
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
				
		return message;
	}

	@Override
	public List<Course> getCourseDetails(String cname) throws CourseException {

		List<Course> courseList = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from course where cname = ?");
			
			ps.setString(1, cname);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String n = rs.getString("cname");
				int b = rs.getInt("batch");
				int f = rs.getInt("fee");
				int s = rs.getInt("totalseats");
				
				Course course = new Course(cid, n, b, f, s);
				
				courseList.add(course);
			
			}
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		if (courseList.isEmpty()) {
			throw new CourseException("No details found for this course");
		}
		
		return courseList;
	}

	@Override
	public String addBatch(Course course) throws CourseException {
		
		String message = "Batch addition failed.";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("insert into course(cname,batch,fee,totalseats) values(?,?,?,?)");
					
			ps.setString(1, course.getCname());
			ps.setInt(2, course.getBatch());
			ps.setInt(3, course.getFee());
			ps.setInt(4, course.getTotalseats());
			
			
			int x = ps.executeUpdate();
			
			if (x>0) {
				
				message = "Batch added successfully."; 	
				
			}
		} catch (SQLException e) {
			
			message=e.getMessage();
		}
				
				
		return message;
	}

	@Override
	public String allocateStudent(int roll, int cid) throws CourseException, StudentException {
		String message ="Not Registered";
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from student where roll =?");
			
		 	
		 	ps.setInt(1, roll);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from course where cid=?");
		 		
		 		ps2.setInt(1, cid);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into course_student values(?,?)");
		 			
		 			
		 			ps3.setInt(1, cid);
		 			ps3.setInt(2, roll);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Student registered inside the Course Sucessfully.. ";
		 			else
		 				throw new StudentException("Techical error..");
		 			
		 			
		 			
		 		}
		 		else
		 			throw new CourseException("Invalid Course...");
		 		
			
		 		
		 	}else
		 		throw new StudentException("Invalid Student...");
			
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
				
		return message;
	}

	@Override
	public List<Course> getAllCourses() throws CourseException {

		List<Course> courseList = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from course order by cname");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int batch = rs.getInt("batch");
				
				
				Course course = new Course();
				course.setCid(cid);
				course.setCname(cname);
				course.setBatch(batch);
				
				courseList.add(course);
			
			}
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		if (courseList.isEmpty()) {
			throw new CourseException("No courses available");
		}
		
		return courseList;
	
	}

	@Override
	public String updateTotalSeats(String cname, int batch, int totalSeats) throws CourseException {
		
			String message = "Batch "+ batch +" for "+cname+" course not found.";
		
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("UPDATE course SET totalseats = ? where cname = ? AND batch = ?");
					
				ps.setInt(1, totalSeats);
				ps.setString(2, cname);
				ps.setInt(3, batch);
				
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Total seats for "+cname+" course "+batch+" batch have been updated";
			} else {
				throw new CourseException("Invalid Course...");
			}
					
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return message;

	}

	@Override
	public List<StudentDTO> getBatchwiseStudents() throws CourseException {
		
		List<StudentDTO> dtos = new ArrayList<>();
		
		

		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement(" select c.cid,c.cname,c.batch, s.roll, s.name,s.email,c.fee from  student s INNER JOIN course c INNER JOIN course_student cs ON s.roll = cs.roll AND c.cid = cs.cid order by c.cname,c.batch,s.roll");
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int batch = rs.getInt("batch");
				int roll = rs.getInt("roll");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int fee = rs.getInt("fee");
					
				StudentDTO dto = new StudentDTO(roll, email, name, cname, cid, batch, fee);
				
				dtos.add(dto);
				
				
			}
		
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		
		
		if(dtos.isEmpty())
			throw new CourseException("No active courses found");
		
		
		return dtos;
		
	}

	@Override
	public List<CourseDTO> seatAvailability() throws CourseException {
		
		List<CourseDTO> dtos = new ArrayList<>();
		
try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select course.cid, count(course_student.cid) as count, course.cname, course.batch, course.fee, course.totalseats from course left join course_student on course.cid=course_student.cid group by cid");
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				 int cid = rs.getInt("cid");
				 String cname = rs.getString("cname");
				 int batch = rs.getInt("batch");
				 int fee = rs.getInt("fee");
				 int totalseats = rs.getInt("totalseats");
				 int seatsfilled = rs.getInt("count");
				 int seatsAvailable = totalseats - seatsfilled;
				
					
				CourseDTO dto = new CourseDTO(cid, cname, batch, fee, totalseats, seatsfilled, seatsAvailable);
				
				dtos.add(dto);
				
				
			}
		
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		
		
		if(dtos.isEmpty())
			throw new CourseException("No active courses found");
		
		
		return dtos;
	}

	

}
