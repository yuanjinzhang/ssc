package com.scs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.beans.Apply;
import com.scs.beans.Course;
import com.scs.beans.User;
import com.scs.comon.ResponseModel;
import com.scs.mapper.LoginMapper;
import com.scs.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public User getUserByWornNo(String workno) {
		// TODO Auto-generated method stub
		return loginMapper.getUserByWornNo(workno);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return loginMapper.getUserList();
	}

	
	@Override
	public ResponseModel<User> listUsers(int offset,int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();
		
		List<User> userList=loginMapper.listUsers(offset,pageSize);
		
		return new ResponseModel<User>(userList, total);

	}
	
	@Override
	public ResponseModel<Apply> applyList(int offset,int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();
		
		List<Apply> userList=loginMapper.applyList(offset,pageSize);
		
		return new ResponseModel<Apply>(userList, total);

	}
	
	@Override
	public ResponseModel<Course> listCourse(int offset,int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();
		
		List<Course> userList=loginMapper.listCourse(offset,pageSize);
		
		return new ResponseModel<Course>(userList, total);

	}

}
