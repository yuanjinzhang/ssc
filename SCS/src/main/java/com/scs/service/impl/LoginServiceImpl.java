package com.scs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scs.beans.Apply;
import com.scs.beans.Course;
import com.scs.beans.SelectCourses;
import com.scs.beans.User;
import com.scs.comon.ResponseModel;
import com.scs.mapper.LoginMapper;
import com.scs.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public User getUserByWornNo(String workno) {
		// TODO Auto-generated method stub
		return loginMapper.getUserByWornNo(workno);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return loginMapper.getUserList();
	}
	
	@Override
	public ResponseModel<User> listUsers(int offset,int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();
		
		List<User> userList=loginMapper.listUsers(offset,pageSize);
		
		return new ResponseModel<User>(userList, total);

	}
	
	//选课信息
	@Override
	public ResponseModel<Course> listCourse(int offset,int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();		
		List<Course> userList=loginMapper.listCourse(offset,pageSize);
		return new ResponseModel<Course>(userList, total);

	}

	@Override
	public ResponseModel<Course> updateCourse(Course course) {
		// TODO Auto-generated method stub
		ResponseModel<Course> resModel=new ResponseModel<Course>();
		loginMapper.updateCourse(course);
		resModel.setStatus(200);
		resModel.setMsg("修改成功");
		return resModel;
	}
	
	//学生选课
	@Override
	public ResponseModel<SelectCourses> listSelectCourses(int offset, int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();		
		List<SelectCourses> userList=loginMapper.listSelectCourses(offset,pageSize);
		return new ResponseModel<SelectCourses>(userList, total);
	}

	//查询需要的安排课程
	@Override
	public ResponseModel<Course> arrangeCourse(int offset, int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();		
		List<Course> userList=loginMapper.arrangeCourse(offset,pageSize);
		return new ResponseModel<Course>(userList, total);
	
	}
	
	//审核开课信息
	@Override
	public ResponseModel<Apply> applyList(int offset,int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();
		List<Apply> userList=loginMapper.applyList(offset,pageSize);
		return new ResponseModel<Apply>(userList, total);
	}
	//审核开课信息通过，添加入课程信息
	@Override
	public ResponseModel<Course> insertCourse(Course course) {
		// TODO Auto-generated method stub
		ResponseModel<Course> resModel=new ResponseModel<Course>();
			loginMapper.insertCourse(course);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		return resModel;
	}
	//审核未通过，删除申请
	@Override
	public ResponseModel<Apply> deleteApply(Apply apply) {
		// TODO Auto-generated method stub
		int status=loginMapper.deleteApply(apply);
		ResponseModel<Apply> resModel=new ResponseModel<Apply>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		return resModel;
	}
	//教务修改学生成绩
	@Override
	public ResponseModel<SelectCourses> updateSelectCourse(SelectCourses selectCourses) {
		// TODO Auto-generated method stub
		ResponseModel<SelectCourses> resModel=new ResponseModel<SelectCourses>();
		loginMapper.updateSelectCourse(selectCourses);
		resModel.setStatus(200);
		resModel.setMsg("修改成功");	
	return resModel;
	}
	//安排课程地点和时间
	@Override
	public ResponseModel<Course> updatearrangeCourse(Course course) {
		// TODO Auto-generated method stub
			ResponseModel<Course> resModel=new ResponseModel<Course>();
				loginMapper.updatearrangeCourse(course);
				resModel.setStatus(200);
				resModel.setMsg("修改成功");
			
			return resModel;
	}

}
