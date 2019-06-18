package com.scs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.scs.beans.User;
import com.scs.comon.RequestModel;
public interface update_userMapper {
	@Select("select * from lab_user")
	List<User> getUserList();
	
	/*@Select("select u.*,p.position_name from lab_user as u join lab_userposition as p on u.id=p.id")
	List<User> listUsers();*/

	@Select("select count(*) from lab_user ")
	int getUserTotal();

	@Select("select * from lab_user limit #{offset},#{pageSize}")
	List<User> getUsers(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Update("UPDATE lab_user SET college=#{college},status=#{status} WHERE id=#{id}")
	int update(User user);
	
	@Select("SELECT COUNT(*) FROM Lab_USER WHERE id=#{id}")
	int checkId(User user);
	
	@Delete("DELETE FROM lab_user WHERE id=#{id}")
	int delete(User user);
	
	@Select("SELECT * FROM lab_user "
			+ "WHERE state=1 and  and id LIKE CONCAT('%',#{param.Id},'%')" 
			+ "ORDER BY ${pageModel.sort} ${pageModel.order} "
			+ "limit #{pageModel.offset},#{pageModel.limit} ")
	List<User> listUsers(RequestModel<User> reqModel);
}