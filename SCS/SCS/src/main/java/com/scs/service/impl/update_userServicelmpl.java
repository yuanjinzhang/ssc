package com.scs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scs.beans.User;
import com.scs.comon.RequestModel;
import com.scs.comon.ResponseModel;
import com.scs.mapper.update_userMapper;
import com.scs.service.update_userService;

	@Service
	public class update_userServicelmpl implements update_userService{
		@Autowired
		private update_userMapper update_userMapper;	
		
		@Override
		@Transactional
		public List<User> getUserList() {
			// TODO Auto-generated method stub
			return update_userMapper.getUserList();
		}	
		@Override
		@Transactional
		public ResponseModel<User> getUsers(int offset, int pageSize) {
			// TODO Auto-generated method stub
			int total=update_userMapper.getUserTotal();
			List<User> users=update_userMapper.getUsers(offset,pageSize);			
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

		
		/*@Override
		@Transactional
		public ResponseModel<User> listUsers(RequestModel<User> reqModel) {
			// TODO Auto-generated method stub
			int total=update_userMapper.getUserTotal();			
			List<User> userList=update_userMapper.listUsers(reqModel);			
			return new ResponseModel<User>(userList, total);
		}*/

	}
	


