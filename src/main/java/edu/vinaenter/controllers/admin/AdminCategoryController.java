package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import edu.vinaenter.models.Category;
import edu.vinaenter.service.CatService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CAT)
public class AdminCategoryController {
	@Resource
	protected MessageSource messageSource;
	@Autowired
	private CatService catService;
//	@Autowired // DI
//	private DateValidator dateValidator;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE, URLConstant.INDEX_SEARCH })
	public String index(Model model, @RequestParam(required = false) String search,
			@PathVariable(required = false) String page, Category category) {
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
		int  totalPage = PageUtil.getTotalPage(catService.totalRow());
		System.out.println("fdsjfhjsf" + search);
		List<Category> catsList = catService.getAll(offset, GlobalConstant.TOTAL_ROW);
		if (!"".equals(search) && search != null) {
			catsList = catService.getSearch(search, offset, GlobalConstant.TOTAL_ROW);
			totalPage = PageUtil.getTotalPage(catService.totalRowSearch(search));
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("catList", catsList);
		model.addAttribute("search", search);
		return "admin.cat.index";
	}

	@GetMapping(URLConstant.DELETE)
	public String del(@RequestParam int cid, @ModelAttribute("cat") Category cat, BindingResult rs,
			RedirectAttributes rd) {
		Category category = catService.findById(cid);
		System.out.println(category);
		if (category != null) {
			catService.del(category);
			rd.addFlashAttribute("msg", messageSource.getMessage("del.success", null, Locale.getDefault()));
		}
		return "redirect:/admin/cat/index";
	}

	@GetMapping(URLConstant.ADD)
	public String add() {

		return "admin.cat.add";
	}

	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("cat") Category cat, BindingResult rs, RedirectAttributes rd) {
		if (rs.hasErrors()) {
			System.out.println("Co' loi data");
			return "admin.cat.add";
		}
		if (catService.save(cat) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		return "admin.cat.add";
	}

	@GetMapping(URLConstant.EDIT)
	public String edit(Model model, @RequestParam String cid, @ModelAttribute("cat") Category cat, BindingResult rs,
			RedirectAttributes rd) {
		int catId = 0;
		try {
			catId = Integer.parseInt(cid);
			if (catId < 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:/error/404";
		}
		Category catFindId = catService.findById(catId);
		model.addAttribute("catFindId", catFindId);
		return "admin.cat.edit";
	}

	@PostMapping(URLConstant.EDIT)
	public String edit(@ModelAttribute("cat") Category cat, BindingResult rs, RedirectAttributes rd) {
		if (catService.update(cat) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("edit.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		return "admin.cat.edit";
	}

}
