package webadv.S16204113.p7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import domain.Teacher;
import repository.TeacherRepository;

@Controller
public class HomeController {
	@Autowired 
	private TeacherRepository repository;
	
	
	@PostMapping("/login")
	public String login(Model model,String account, String password) {
		if ("abc".equals(account) && "123".equals(password)) {
			List<Teacher> list = repository.findAll();
			for (Teacher t:list) {
				System.out.println(t.getName());;
			}
			return "home";
		}
			
		else
			return "index";
	}
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "home";
	}
}

