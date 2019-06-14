package com.scs.service;

import java.util.List;

import com.scs.beans.User;

public interface LoginService {
	User getUserByWornNo(String workno);
	List<User> getUserList();
}
