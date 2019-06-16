package com.scs.mapper;

import java.text.ParsePosition;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.scs.beans.Apply;
import com.scs.beans.Course;
import com.scs.beans.SelectCourses;
import com.scs.beans.User;
import com.scs.beans.userPosition;

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
	
	@Select("select * from lab_course")
	List<Course> getCourseList();
	
	@Select("SELECT count(*) from lab_user")
	int getTotal();

	@Select("select * from lab_apply a left join lab_user u on a.user_id=u.id where position_id=1 limit #{offset},#{pageSize}  ")
	List<User> listUsers(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Select("select * from lab_apply a left join lab_user u on a.user_id=u.id  limit #{offset},#{pageSize} ")
	List<Apply> applyList(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Select("select * from lab_course c left join lab_user u on c.user_id=u.id where c.status=0  limit #{offset},#{pageSize} ")
	List<Apply> listCourse(@Param("offset")int offset, @Param("pageSize")int pageSize);

}
