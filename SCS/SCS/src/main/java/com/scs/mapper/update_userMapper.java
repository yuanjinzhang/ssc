package com.scs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.scs.beans.User;
public interface update_userMapper {
	@Select("select * from lab_user")
	List<User> getUserList();

	@Select("select count(*) from lab_user ")
	int getUserTotal();

	@Select("select * from lab_user limit #{offset},#{pageSize}")
	List<User> getUsers(@Param("offset")int offset, @Param("pageSize")int pageSize);
}