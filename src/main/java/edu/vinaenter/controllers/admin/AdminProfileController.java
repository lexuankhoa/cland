package edu.vinaenter.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.constant.URLConstant;

@Controller
@RequestMapping(URLConstant.URL_ADMIN)
public class AdminProfileController {
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	private MessageSource messageSource;
//	
//	@Autowired
//	private RoleService roleService;
//	
//	@Autowired
//	private UserService userService;
	
	@GetMapping("/profile"/* URLConstant.URL_PROFILE */)
	public String profile() {
		return "admin.profile";
	}
}
