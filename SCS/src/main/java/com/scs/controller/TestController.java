package com.scs.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scs.beans.Teacher;
import com.scs.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping("/getAllTeachers")
	@ResponseBody
	public List<Teacher> getAllTeachers(){
		return testService.getTeachers();
	}
}
