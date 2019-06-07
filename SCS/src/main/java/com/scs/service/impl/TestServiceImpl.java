package com.scs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scs.beans.Teacher;
import com.scs.mapper.TestMapper;
import com.scs.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestMapper testMapper;
	
	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return testMapper.getTeachers();
	}
	
}
