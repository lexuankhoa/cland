package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Role;
import edu.vinaenter.models.User;
import edu.vinaenter.service.RoleService;
import edu.vinaenter.service.UserService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_USER)
public class AdminUserController {
	@Resource
	protected MessageSource messageSource;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Autowired // DI
//	private DateValidator dateValidator;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE, URLConstant.INDEX_SEARCH })
	public String index(Model model, @RequestParam(required = false) String search,
			@PathVariable(required = false) String page, User user, RedirectAttributes ra) {
		int currentPage = 1;
		if (page != null) {
			try {
				currentPage = Integer.parseInt(page);
				if (currentPage < 1) {
					throw new Exception();
				}
			} catch (Exception e) {
				return "redirect:/error/404";
			}
		}
		int offset = PageUtil.getOffset(currentPage);
		List<User> userList = userService.getAll(offset, GlobalConstant.TOTAL_ROW);
		int totalPage = PageUtil.getTotalPage(userService.totalRow());
		if (!"".equals(search) && search != null) {
			userList = userService.getSearch(search, offset, GlobalConstant.TOTAL_ROW);
			totalPage = PageUtil.getTotalPage(userService.totalRowSearch(search));
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("userList", userList);
		model.addAttribute("search", search);
		return "admin.user.index";
	}

	@GetMapping(URLConstant.DELETE)
	public String del(@RequestParam int id, @ModelAttribute("user") User user, BindingResult rs,
			RedirectAttributes rd) {
		User User = userService.findById(id);
		if (User != null) {
			userService.del(User);
			rd.addFlashAttribute("msg", messageSource.getMessage("del.success", null, Locale.getDefault()));
		}
		return "redirect:/admin/user/index";
	}

	@GetMapping(URLConstant.ADD)
	public String add(Model model) {
		List<Role> roleList = roleService.getAll();
		model.addAttribute("roleList", roleList);
		return "admin.user.add";
	}

	@PostMapping(URLConstant.ADD)
	public String add(@RequestParam int role, @Valid @ModelAttribute("user") User user, BindingResult rs,
			RedirectAttributes rd, ModelMap modelMap) {
		List<Role> roleList = roleService.getAll();
		modelMap.addAttribute("roleList", roleList);
		if (userService.hasUser(user.getUsername())) {
			rd.addFlashAttribute("err", messageSource.getMessage("err.has", null, Locale.getDefault()));
			return "redirect:/admin/user/add";
		}
		if (rs.hasErrors()) {
			return "admin.user.add";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User users = new User(user.getUsername(), user.getFullname(), user.getPassword(), role);
		if (userService.save(users) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		return "admin.user.add";
	}

	@GetMapping(URLConstant.EDIT)
	public String edit(Model model, @RequestParam String id, @ModelAttribute("user") User user, BindingResult rs,
			RedirectAttributes rd) {
		int userId = 0;
		try {
			userId = Integer.parseInt(id);
			if (userId < 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:/error/404";
		}
		User userFindId = userService.findById(userId);
		model.addAttribute("userFindId", userFindId);
		List<Role> roleList = roleService.getAll();
		model.addAttribute("roleList", roleList);
		return "admin.user.edit";
	}

	@PostMapping(URLConstant.EDIT)
	public String edit(@RequestParam int role, @ModelAttribute("user") User user, BindingResult rs,
			RedirectAttributes rd, ModelMap modelMap) {
		if (rs.hasErrors()) {
			return "admin.user.edit";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User users = new User(user.getId(), user.getUsername(), user.getFullname(), user.getPassword(), role);
		if (userService.update(users) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("edit.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		return "admin.user.edit";
	}
}
