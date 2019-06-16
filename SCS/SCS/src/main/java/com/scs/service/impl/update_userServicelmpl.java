package com.scs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scs.beans.User;
import com.scs.comon.ResponseModel;
import com.scs.mapper.update_userMapper;
import com.scs.service.update_userService;

	@Service
	public class update_userServicelmpl implements update_userService{
		@Autowired
		private update_userMapper update_teacherListMapper;	
		@Override
		@Transactional
		public List<User> getUserList() {
			// TODO Auto-generated method stub
			return update_teacherListMapper.getUserList();
		}	
		@Override
		@Transactional
		public ResponseModel<User> getUsers(int offset, int pageSize) {
			// TODO Auto-generated method stub
			int total=update_teacherListMapper.getUserTotal();
			List<User> teachers=update_teacherListMapper.getUsers(offset,pageSize);			
			return new ResponseModel<User>(teachers,total);
		}
	}


