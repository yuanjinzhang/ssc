package com.scs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.scs.beans.Lab;
public interface getLabListMapper {
	@Select("select * from lab_lab")
	List<Lab> getLabList();

	@Select("select count(*) from lab_lab")
	int getTotal();

	@Select("select * from lab_lab limit #{offset},#{pageSize}")
	List<Lab> getLabs(@Param("offset")int offset, @Param("pageSize")int pageSize);	
	//@Select("select * from lab_lab")
	//List<Lab> getLabs();
}
