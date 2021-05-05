package edu.vinaenter.controllers.auth;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.models.User;
import edu.vinaenter.service.UserService;
@Scope(value="session")
@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String index(ModelMap modelMap, @ModelAttribute("user") User user) {
		return "admin.login";
	}
}
