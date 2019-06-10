package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import domain.Teacher;

@Repository
public class TeacherRepository {	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	public List<Teacher> findAll(){	
		String sql="select * from t_teacher";
		RowMapper<Teacher> rowMapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
		List<Teacher> list = jdbcTemplate.query(sql, rowMapper);	
		
		return list;	
	}
	
	public Teacher validTeacher(String account,String password) {
		String sql="select teacher_id as id,teacher_account as account,teacher_name as name from t_teacher where teacher_account='teacher' and teacher_password=md5(123)";
		RowMapper<Teacher> rowMapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
		List<Teacher> list = jdbcTemplate.query(sql, rowMapper,account,password);	
		if (list != null && list.size()>0) {
			System.out.println(list.get(0).getName());
			return list.get(0);
		}else
			return null;
	
	}

	
	
}