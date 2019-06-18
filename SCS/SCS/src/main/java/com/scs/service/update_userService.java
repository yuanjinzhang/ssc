package com.scs.service;

import java.util.List;
import com.scs.beans.User;
import com.scs.comon.RequestModel;
import com.scs.comon.ResponseModel;

public interface update_userService {
    List<User> getUserList();	
	ResponseModel<User> getUsers(int offset,int pageSize);
	ResponseModel<User> update(User user);
	ResponseModel<User> delete(User user);
	//ResponseModel<User> listUsers(RequestModel<User> reqModel);
}
