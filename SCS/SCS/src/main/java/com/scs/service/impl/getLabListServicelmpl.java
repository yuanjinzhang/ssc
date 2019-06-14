package com.scs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scs.beans.Lab;
import com.scs.comon.ResponseModel;
import com.scs.mapper.getLabListMapper;
import com.scs.service.getLabListService;


	@Service
	public class getLabListServicelmpl implements getLabListService{
		@Autowired
		private getLabListMapper getLabListMapper;	
		@Override
		@Transactional
		public List<Lab> getLabList() {
			// TODO Auto-generated method stub
			return getLabListMapper.getLabList();
		}	
		@Override
		@Transactional
		public ResponseModel<Lab> getLabs(int offset, int pageSize) {
			// TODO Auto-generated method stub
			int total=getLabListMapper.getLabTotal();
			List<Lab> labs=getLabListMapper.getLabs(offset,pageSize);			
			return new ResponseModel<Lab>(labs,total);
		}
	}


