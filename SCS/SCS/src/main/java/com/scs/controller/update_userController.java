package com.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scs.beans.User;
import com.scs.comon.PageModel;
import com.scs.comon.RequestModel;
import com.scs.comon.ResponseModel;
import com.scs.service.update_userService;


@Controller
public class update_userController {
	@Autowired
	private update_userService update_userService;
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public ResponseModel<User> getLabList(@RequestBody RequestModel<User> reqModel){
		PageModel pageModel=reqModel.getPageModel();
		return update_userService.getUsers(pageModel.getOffset(), pageModel.getPageSize());
	}
	@RequestMapping("/update_user/update")
	@ResponseBody
	public ResponseModel<User> update(@RequestBody User user) {
		return update_userService.update(user);
	}
	
	@RequestMapping("/update_user/delete")
	@ResponseBody
	public ResponseModel<User> delete(@RequestBody User user) {
		return update_userService.delete(user);
	}
	
	/*@RequestMapping("/listUsers")
	@ResponseBody
	public ResponseModel<User> lilstUsers(@RequestBody RequestModel<User> reqModel){
		ResponseModel<User> resModel=update_userService.listUsers(reqModel);		
		return resModel;
	}*/
	
}


