package webadv.S16204113.p7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import domain.Teacher;
import repository.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class P7ApplicationTests {
	@Autowired
	private TeacherRepository tr;
	
	@Test
	public void contextLoads() {
		Teacher t=tr.validTeacher("teacher","123");
		//assertEquals(t.getAccount(),"teacher");
		System.out.println(t.getAccount());
	}

}
