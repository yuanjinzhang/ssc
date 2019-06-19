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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.scs.beans.User;
import com.scs.service.LoginService;
import com.scs.service.TestService;


@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
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
}
