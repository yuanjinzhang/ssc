package com.scs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.scs.beans.Apply;
import com.scs.beans.User;

@Mapper
public interface LoginMapper {
	@Select("select * from lab_user where workno=#{workno} ")
	User getUserByWornNo(@Param("workno") String workno);

	@Select("select * from lab_apply")
	@Results({
		@Result(property = "user" ,column = "user_id",one = @One(select = "com.scs.mapper.getUserById"))
	})
	List<Apply> getApplyList();
	
	@Select("select * from lab_user")
	List<User> getUserList();
	
	@Select("select * from lab_user where id=#{id}")
	User getUserById(@Param("id") int id);
}
