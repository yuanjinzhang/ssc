package com.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scs.beans.User;
import com.scs.service.LoginService;

@Controller
public class ShowInfoController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/index")
	public String info(String username,String password) {
			User loginUser=loginService.getUserByWornNo(username);		
			return loginUser.getName();
	}
}
