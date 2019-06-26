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
import com.scs.beans.Course;
import com.scs.beans.SelectCourses;
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
	public ResponseModel<User> lilstUsers(@RequestBody RequestModel<User> reqModel){
		PageModel pModel=reqModel.getPageModel();
		ResponseModel<User> resModel=loginService.listUsers(pModel.getOffset(),pModel.getPageSize());	
		return resModel;
	}
	
	//ѧ��ѡ��
	@RequestMapping("/student/select/course")
	@ResponseBody
	public ResponseModel<SelectCourses> listSelectCourses(@RequestBody RequestModel<SelectCourses> reqModel){
		PageModel pageModel=reqModel.getPageModel();
		ResponseModel<SelectCourses> responseModel=loginService.listSelectCourses(pageModel.getOffset(),pageModel.getPageSize());
		return responseModel;
	}
	//�޸�ѧ���ɼ�
	@RequestMapping("/update/selectCourse")
	@ResponseBody
	public ResponseModel<SelectCourses> updateSelectCourse(@RequestBody SelectCourses selectCourses) {

		return loginService.updateSelectCourse(selectCourses);
	}
	
	@RequestMapping("/arrange/course")
	@ResponseBody
	public ResponseModel<Course> arrangeCourse(@RequestBody RequestModel<SelectCourses> reqModel){
		PageModel pageModel=reqModel.getPageModel();
		ResponseModel<Course> responseModel=loginService.arrangeCourse(pageModel.getOffset(),pageModel.getPageSize());
		return responseModel;
	}
	//home��Ӧ�������Կ�����Ϣ�������
	@RequestMapping("/teacher/apply")
	@ResponseBody
	public ResponseModel<Apply> applyList(@RequestBody RequestModel<Apply> reqModel){
		PageModel pageModel=reqModel.getPageModel();
		ResponseModel<Apply> resModel=loginService.applyList(pageModel.getOffset(),pageModel.getPageSize());	
		return resModel;
	}
	//���ͨ���Ŀγ̣���ӵ��γ̱���
	@RequestMapping("/course/insert")
	@ResponseBody
	public ResponseModel<Course> insertCourse(@RequestBody Course course) {

		return loginService.insertCourse(course);
	}
	
	//���ͨ��ɾ��Apply��Ϣ
	@RequestMapping("/delete/apply")
	@ResponseBody
	public ResponseModel<Apply> deleteApply(@RequestBody Apply apply) {
		return loginService.deleteApply(apply);
	}
	
	//ѡ����Ϣ
	@RequestMapping("/course/select")
	@ResponseBody
	public ResponseModel<Course> listCourse(@RequestBody RequestModel<Course> reqModel){
		PageModel pageModel=reqModel.getPageModel();
		ResponseModel<Course> resModel=loginService.listCourse(pageModel.getOffset(),pageModel.getPageSize());	
		return resModel;
	}
	//��˿γ̣�ͨ����Ϊ��ѡ��
	@RequestMapping("/update/course")
	@ResponseBody
	public ResponseModel<Course> updateCourse(@RequestBody Course course) {
		return loginService.updateCourse(course);
	}
	//���ſγ�ʱ��ص�
	@RequestMapping("/arrange/course/update")
	@ResponseBody
	public ResponseModel<Course> updatearrangeCourse(@RequestBody Course course) {
		return loginService.updatearrangeCourse(course);
	}
	
}
