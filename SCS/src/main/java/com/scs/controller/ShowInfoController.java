package com.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scs.beans.Apply;
import com.scs.beans.User;
import com.scs.comon.RequestModel;
import com.scs.comon.ResponseModel;
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
	
	@RequestMapping("/teacherApplyUpdate")
	@ResponseBody
	public ResponseModel<Apply> teacherApplyUpdate(@RequestBody Apply apply){
		System.out.println(apply.getApplyno());
		System.out.println(apply.getCname());
		return new ResponseModel<Apply>();
	}
	
}
