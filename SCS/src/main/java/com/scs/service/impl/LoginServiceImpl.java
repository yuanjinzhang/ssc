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
	
	//ѡ����Ϣ
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
		resModel.setMsg("�޸ĳɹ�");
		return resModel;
	}
	
	//ѧ��ѡ��
	@Override
	public ResponseModel<SelectCourses> listSelectCourses(int offset, int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();		
		List<SelectCourses> userList=loginMapper.listSelectCourses(offset,pageSize);
		return new ResponseModel<SelectCourses>(userList, total);
	}

	//��ѯ��Ҫ�İ��ſγ�
	@Override
	public ResponseModel<Course> arrangeCourse(int offset, int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();		
		List<Course> userList=loginMapper.arrangeCourse(offset,pageSize);
		return new ResponseModel<Course>(userList, total);
	
	}
	
	//��˿�����Ϣ
	@Override
	public ResponseModel<Apply> applyList(int offset,int pageSize) {
		// TODO Auto-generated method stub
		int total=loginMapper.getTotal();
		List<Apply> userList=loginMapper.applyList(offset,pageSize);
		return new ResponseModel<Apply>(userList, total);
	}
	//��˿�����Ϣͨ���������γ���Ϣ
	@Override
	public ResponseModel<Course> insertCourse(Course course) {
		// TODO Auto-generated method stub
		ResponseModel<Course> resModel=new ResponseModel<Course>();
			loginMapper.insertCourse(course);
			resModel.setStatus(200);
			resModel.setMsg("��ӳɹ�");
		return resModel;
	}
	//���δͨ����ɾ������
	@Override
	public ResponseModel<Apply> deleteApply(Apply apply) {
		// TODO Auto-generated method stub
		int status=loginMapper.deleteApply(apply);
		ResponseModel<Apply> resModel=new ResponseModel<Apply>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("�޸ĳɹ�");
		}
		return resModel;
	}
	//�����޸�ѧ���ɼ�
	@Override
	public ResponseModel<SelectCourses> updateSelectCourse(SelectCourses selectCourses) {
		// TODO Auto-generated method stub
		ResponseModel<SelectCourses> resModel=new ResponseModel<SelectCourses>();
		loginMapper.updateSelectCourse(selectCourses);
		resModel.setStatus(200);
		resModel.setMsg("�޸ĳɹ�");	
	return resModel;
	}
	//���ſγ̵ص��ʱ��
	@Override
	public ResponseModel<Course> updatearrangeCourse(Course course) {
		// TODO Auto-generated method stub
			ResponseModel<Course> resModel=new ResponseModel<Course>();
				loginMapper.updatearrangeCourse(course);
				resModel.setStatus(200);
				resModel.setMsg("�޸ĳɹ�");
			
			return resModel;
	}

}
