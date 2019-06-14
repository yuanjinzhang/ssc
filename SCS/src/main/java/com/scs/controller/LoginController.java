package com.scs.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scs.beans.Apply;
import com.scs.beans.Teacher;
import com.scs.beans.User;
import com.scs.comon.PageModel;
import com.scs.comon.RequestModel;
import com.scs.comon.ResponseModel;
import com.scs.mapper.LoginMapper;
import com.scs.service.LoginService;
import com.scs.service.TestService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginMapper loginMapper;
	
	@RequestMapping("/login")
	public String login(String username,String password,Model model) {
		if(username==null||password==null)
			return "login";
		else {
			User loginUser=loginService.getUserByWornNo(username);
			if (loginUser==null) {
				return "login";
			}
			if (password.equals(loginUser.getPassword())) {
				List<User> userList=loginService.getUserList();
				model.addAttribute("usersList",userList);
				return "home";
			}
			return "login";
		}
	}
	@RequestMapping("/student/listUsers")
	@ResponseBody
	public ResponseModel<User> lilstUsers(@RequestBody RequestModel<User> reqModel1){
		PageModel pModel=reqModel1.getPageModel();
		ResponseModel<User> resModel=loginService.listUsers(pModel.getOffset(),pModel.getPageSize());	
		return resModel;
	}
	
	@RequestMapping("/teacher/apply")
	@ResponseBody
	public ResponseModel<Apply> applyList(@RequestBody RequestModel<Apply> reqModel2){
		PageModel pageModel=reqModel2.getPageModel();
		ResponseModel<Apply> resModel=loginService.applyList(pageModel.getOffset(),pageModel.getPageSize());	
		return resModel;
	}

}
