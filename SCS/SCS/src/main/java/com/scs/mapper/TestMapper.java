package com.scs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.scs.beans.Lab;
import com.scs.beans.Teacher;


@Mapper
public interface TestMapper {
	@Select("select * from teacher")
	List<Teacher> getTeachers();	
	
	@Select("select * from lab_lab")
	List<Lab> getLabList();

	@Select("select count(*) from lab_lab")
	int getLabTotal();

	@Select("select * from lab_lab limit #{offset} #{pageSize}")
	List<Lab> getLabs(@Param("offset")int offset, @Param("pageSize")int pageSize);	
}
