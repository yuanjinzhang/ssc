package com.scs.service;


import com.scs.beans.User;
import com.scs.comon.ResponseModel;

public interface update_userService {
	ResponseModel<User> getUserList(int offset,int pageSize);
	ResponseModel<User> update(User user);
	ResponseModel<User> delete(User user);
}
