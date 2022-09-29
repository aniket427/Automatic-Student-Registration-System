package com.project.Dao;

import java.util.List;

import com.project.bean.Course;
import com.project.exceptions.CourseException;
import com.project.exceptions.StudentException;

public interface CourseDao {

	public String addCourse(Course course);
	
	public int getlastbatch(String cname);
	
	public String updateFee(String cname, int batch, int fee);
	
	public String deleteCourse(String cname, int batch);
	
	public List<Course> getCourseDetails(String cname)throws CourseException;
	
	public String addBatch(Course course) throws CourseException;
	
	public String allocateStudent(int roll, int cid) throws CourseException, StudentException;

	public List<Course> getAllCourses() throws CourseException;
}
