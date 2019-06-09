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


@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(String username,String password) {
		if(username==null||password==null)
			return "login";
		else {
			User loginUser=loginService.getUserByWornNo(username);
			if (loginUser==null) {
				return "login";
			}
			if (password.equals(loginUser.getPassword())) {
				return "home";
			}
			return "login";
		}
	}
	@RequestMapping("/search")
	public String search() {
		
		return "semester";
	}
	@RequestMapping("/semester")
	public String semester() {
		
		return "home";
	}
	
	@RequestMapping("/selectInfo")
	public String selectInfo() {
		
		return "selectInfo";
	}
	@RequestMapping("/studentSelect")
	public String studentSelect() {
		
		return "studentSelect";
	}
	@RequestMapping("/arrangement")
	public String arrangement() {
		
		return "arrangement";
	}
}