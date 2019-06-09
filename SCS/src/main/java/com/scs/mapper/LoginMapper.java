package com.scs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.scs.beans.User;

@Mapper
public interface LoginMapper {
	@Select("select * from lab_user where workno=#{workno} ")
	User getUserByWornNo(@Param("workno") String workno);
}
