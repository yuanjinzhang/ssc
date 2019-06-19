package com.scs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.scs.beans.User;

public interface update_userMapper {

	@Select("select count(*) from lab_user ")
	int getUserTotal();

	@Select("select u.*,p.position_name,c.cname from lab_user as u left join lab_position as p on u.position_id=p.id left join lab_course as c on u.class_id=c.cno limit #{offset},#{pageSize}")
	List<User> getUserList(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Update("UPDATE lab_user SET college=#{college},status=#{status} WHERE id=#{id}")
	int update(User user);
	
	@Select("SELECT COUNT(*) FROM Lab_USER WHERE id=#{id}")
	int checkId(User user);
	
	@Delete("DELETE FROM lab_user WHERE id=#{id}")
	int delete(User user);
	
}