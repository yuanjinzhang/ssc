package com.scs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scs.beans.Apply;
import com.scs.beans.Lab;
import com.scs.beans.Teacher;
import com.scs.beans.User;
import com.scs.comon.ResponseModel;
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
	
	@Override
	@Transactional
	public List<Lab> getLabList() {
		// TODO Auto-generated method stub
		return testMapper.getLabList();
	}

	@Override
	public List<Apply> getApplyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ResponseModel<Lab> getLabs(int offset, int pageSize) {
		// TODO Auto-generated method stub
		int total=testMapper.getLabTotal();
		List<Lab> labs=testMapper.getLabs(offset,pageSize);
		
		return new ResponseModel<Lab>(labs,total);
	}
}
