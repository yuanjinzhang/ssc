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

	//ѡ����Ϣ
	ResponseModel<Course> listCourse (int offset, int pageSize);
	ResponseModel<Course> updateCourse(Course course);
	
	//ѧ��ѡ��
	ResponseModel<SelectCourses> listSelectCourses(int offset, int pageSize);
	ResponseModel<SelectCourses> updateSelectCourse(SelectCourses selectCourses);
	//�����ڿ�ʱ�䡢�ص�
	ResponseModel<Course> arrangeCourse(int offset, int pageSize);
	ResponseModel<Course> updatearrangeCourse(Course course);
	//������Ϣ
	ResponseModel<Apply> applyList (int offset, int pageSize);
	ResponseModel<Course> insertCourse(Course course);
	ResponseModel<Apply> deleteApply(Apply apply);
}
