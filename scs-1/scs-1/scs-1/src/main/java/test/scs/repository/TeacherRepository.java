package test.scs.repository;

import java.util.List;

import javax.swing.tree.RowMapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;*/
import org.springframework.stereotype.Repository;

import test.scs.entity.Teacher;



/*@Repository
public class TeacherRepository {	
	@Autowired
	//private JdbcTemplate jdbcTemplate;	
	public List<Teacher> findAll(){	
		return null;
	}
	*/
	/*public Teacher validTeacher(String account,String password) {
		String sql="select teacher_id as id,teacher_account as account,teacher_name as name from t_teacher where teacher_account=? and teacher_password=md5(? )";
		RowMapper<Teacher> rowMapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
		List<Teacher> list = jdbcTemplate.query(sql, rowMapper,account,password);	
		if (list != null && list.size()>0) {
			System.out.println(list.get(0).getName());
			return list.get(0);
		}else
			return null;
	
	}*/
	
	@Mapper
public interface TeacherRepository {
		
		@Results(id="teacherMap", value={ 
	    @Result(property = "id", column = "teacher_id",  jdbcType=JdbcType.INTEGER), 
	    @Result(property = "account", column = "teacher_account"),
	    @Result(property = "name", column = "teacher_name")
		})

		@Select("select * from t_teacher") 
		public List<Teacher> findAll();
		
		@Select("select * from t_teacher where teacher_account=#{account} and teacher_password=md5(#{password})")
		@ResultMap(value="teacherMap")
		public Teacher validTeacher(@Param("account")String account,@Param("password")String password);
		
		@Select("select * from t_teacher where teacher_name like concat('%',#{name},'%')")
		@ResultMap(value="teacherMap")			
		public List<Teacher> findByName(@Param("name")String name);
	}

	
	
	
