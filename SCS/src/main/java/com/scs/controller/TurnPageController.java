package com.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scs.service.TurnPageService;

@Controller
public class TurnPageController {
	@Autowired
	private TurnPageService turnPageService;
	
	@RequestMapping("/turnPage/{pid}")
	public String turnPage(@PathVariable("pid") int id) {
		String url=turnPageService.getPageUrlById(id);
		System.out.println("Id:"+id+",URL:"+url);
		return url;
	}
}
