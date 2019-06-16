package com.scs.service;

import java.util.List;

import com.scs.beans.Apply;
import com.scs.beans.Course;
import com.scs.beans.User;
import com.scs.comon.ResponseModel;

public interface LoginService {
	User getUserByWornNo(String workno);
	List<User> getUserList();
	ResponseModel<User> listUsers (int offset, int pageSize);
	ResponseModel<Apply> applyList (int offset, int pageSize);
	ResponseModel<Course> listCourse (int offset, int pageSize);
}
