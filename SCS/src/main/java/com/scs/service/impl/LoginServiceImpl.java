package com.scs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scs.beans.User;
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
	
}
