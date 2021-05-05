package edu.vinaenter.controllers.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.User;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.service.UserService;

@Controller
@RequestMapping(URLConstant.URL_ADMIN)
public class AdminController {
	@Resource
	protected MessageSource messageSource;
	@Autowired
	private CatService catService;
	@Autowired
	private UserService userService;
	@Autowired
	private LandsService landsService;

	@GetMapping(URLConstant.INDEX)
	public String index(Authentication authentication, HttpSession session, Model model) {

		User user = userService.findByUsername(authentication.getName());
		session.setAttribute("user", user);
		List<User> userList = userService.getAll();
		model.addAttribute("userList", userList);
		model.addAttribute("totalCat", catService.totalRow());
		model.addAttribute("totalUser", userService.totalRow());
		model.addAttribute("totalLand", landsService.totalRow());
		return "admin.index";
	}
}
