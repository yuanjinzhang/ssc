package com.scs.service;

import java.util.List;

import com.scs.beans.Apply;
import com.scs.beans.Lab;
import com.scs.beans.Teacher;
import com.scs.beans.User;
import com.scs.comon.ResponseModel;

public interface TestService {
	List<Teacher> getTeachers();
	List<Apply> getApplyList();
	List<Lab> getLabList();
	
	ResponseModel<Lab> getLabs(int offset,int pageSize);

}

