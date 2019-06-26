package com.scs.mapper;

import java.text.ParsePosition;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.scs.beans.Apply;
import com.scs.beans.Course;
import com.scs.beans.SelectCourses;
import com.scs.beans.User;
import com.scs.beans.Position;

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
	
	//开课信息查询，增加课程信息，删除开课申请相关信息
	@Select("select * from lab_apply a left join lab_user u on a.user_id=u.id  limit #{offset},#{pageSize} ")
	List<Apply> applyList(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Insert("INSERT INTO lab_course values(#{cno},#{cname},#{userId},#{credit},#{period},#{num},0,NULL,NULL)")
	@Delete("DELETE FROM lab_apply WHERE applyno=#{cno}")
	int insertCourse(Course course);

	@Delete("DELETE FROM lab_apply WHERE applyno=#{applyno}")
	int deleteApply(Apply apply);

	//选课信息
	@Select("select * from lab_course  where status=0  limit #{offset},#{pageSize} ")
	List<Course> listCourse(@Param("offset")int offset, @Param("pageSize")int pageSize);
	//设置课程为可选课程
	@Update("UPDATE lab_course SET status=1 WHERE cno=#{cno}")
	int updateCourse(Course course);

	//学生选课信息，成绩表
	@Select("select sc.user_id,cname,sc.cno,sc.score from lab_select_courses sc left join lab_course c on c.cno=sc.cno where sc.status=0 limit #{offset},#{pageSize} ")
	List<SelectCourses> listSelectCourses(@Param("offset")int offset, @Param("pageSize")int pageSize);
	//修改学生成绩
	@Update("UPDATE lab_select_courses SET score=#{score},status=1 WHERE user_id=#{userId} and cno=#{cno}")
	int updateSelectCourse(SelectCourses selectCourses);
	//
	@Select("select cno,cname,place,date from lab_course limit #{offset},#{pageSize} ")
	List<Course> arrangeCourse(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Update("UPDATE JCTP_USER SET cno=#{applyno},user_id=#{userId},cname=#{cname} WHERE id=#{id}")
	int updateTeacherApply(User user);
	
	@Update("UPDATE lab_course SET place=#{place},date=#{date} WHERE cno=#{cno}")
	int updatearrangeCourse(Course course);
	
}
