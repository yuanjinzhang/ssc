package com.scs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.scs.beans.Teacher;

@Mapper
public interface TestMapper {
	@Select("select * from t_teacher")
	List<Teacher> getTeachers();	
}
