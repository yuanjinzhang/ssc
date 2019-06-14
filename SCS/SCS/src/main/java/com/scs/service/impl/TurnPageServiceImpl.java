package com.scs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.mapper.TurnPageMapper;
import com.scs.service.TurnPageService;

@Service
public class TurnPageServiceImpl implements TurnPageService{
	@Autowired
	private TurnPageMapper turnpageMapper;
	@Override
	public String getPageUrlById(int id) {
		// TODO Auto-generated method stub
		return turnpageMapper.getPageUrlById(id);
	}

}
