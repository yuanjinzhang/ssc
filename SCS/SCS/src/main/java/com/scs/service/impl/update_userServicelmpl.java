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
		private update_userMapper update_userMapper;	
		
		
		@Override
		@Transactional
		public ResponseModel<User> getUserList(int offset, int pageSize) {
			// TODO Auto-generated method stub
			int total=update_userMapper.getUserTotal();
			List<User> users=update_userMapper.getUserList(offset,pageSize);			
			return new ResponseModel<User>(users,total);
		}
		
		@Override
		@Transactional
		public ResponseModel<User> update(User user) {
			ResponseModel<User> resModel=new ResponseModel<User>();
				update_userMapper.update(user);
				resModel.setStatus(200);
				resModel.setMsg("修改成功");
			return resModel;
		}
		
		@Override
		public ResponseModel<User> delete(User user) {
			ResponseModel<User> resModel=new ResponseModel<User>();
			   update_userMapper.delete(user);
				resModel.setStatus(200);
				resModel.setMsg("修改成功");
			return resModel;
		}			
	}
	


