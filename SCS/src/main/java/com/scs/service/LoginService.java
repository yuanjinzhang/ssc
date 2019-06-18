package com.scs.service;

import java.util.List;

import com.scs.beans.Apply;
import com.scs.beans.Course;
import com.scs.beans.SelectCourses;
import com.scs.beans.User;
import com.scs.comon.ResponseModel;

public interface LoginService {
	User getUserByWornNo(String workno);
	List<User> getUserList();
	ResponseModel<User> listUsers (int offset, int pageSize);

	//选课信息
	ResponseModel<Course> listCourse (int offset, int pageSize);
	ResponseModel<Course> updateCourse(Course course);
	
	//学生选课
	ResponseModel<SelectCourses> listSelectCourses(int offset, int pageSize);
	ResponseModel<SelectCourses> updateSelectCourse(SelectCourses selectCourses);
	//安排授课时间、地点
	ResponseModel<Course> arrangeCourse(int offset, int pageSize);
	ResponseModel<Course> updatearrangeCourse(Course course);
	//开课信息
	ResponseModel<Apply> applyList (int offset, int pageSize);
	ResponseModel<Course> insertCourse(Course course);
	ResponseModel<Apply> deleteApply(Apply apply);
}
