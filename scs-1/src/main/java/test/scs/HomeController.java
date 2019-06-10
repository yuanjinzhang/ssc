package test.scs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.scs.entity.Teacher;
import test.scs.repository.TeacherRepository;

@Controller
public class HomeController {
	@Autowired
	private TeacherRepository tr;

	
	
	@RequestMapping("/login")
	public String login(Model model,String account,String password) {
		if ("1234567".equals(account) && "123".equals(password)) {			
			List<Teacher> list = tr.findAll();
			for (Teacher t:list) {
				System.out.println(t.getName());
			}
			return "home";
		}
		else if("1234".equals(account) && "123".equals(password)){			
			List<Teacher> list = tr.findAll();
			for (Teacher t:list) {
				System.out.println(t.getName());
			}
			return "home1";
		}
			
		else
			return "index";
		
	}
	
	@PostMapping("/search")
	public String doLogin(String name,Model model) {
		model.addAttribute("teacher_list",tr.findByName(name));
		return "home";
	}
	
	@GetMapping("/lookstudent")
	public String lookstudent() {		
		return "lookstudent";
	}
	
	@GetMapping("/lookcmanage")
	public String lookcmanage() {		
		return "lookcmanage";
	}
	
	@GetMapping("/lookteacher")
	public String lookteacher() {		
		return "lookteacher";
	}
	
	@GetMapping("/lookjmanage")
	public String lookjmanage() {		
		return "lookjmanage";
	}
	@GetMapping("/manageexperience")
	public String manageexperience() {		
		return "manageexperience";
	}
	@GetMapping("/lookexperience")
	public String lookexperience() {		
		return "lookexperience";
	}
	@GetMapping("/changeteacher")
	public String changeteacher() {		
		return "changeteacher";
	}
	@GetMapping("/changestudent")
	public String changestudent() {		
		return "changestudent";
	}
	@GetMapping("/changecmanage")
	public String changecmanage() {		
		return "changecmanage";
	}
	@GetMapping("/changejmanage")
	public String changejmanage() {		
		return "changejmanage";
	}
	@GetMapping("/changemanage")
	public String changemanage() {		
		return "changemanage";
	}
}

