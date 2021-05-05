package edu.vinaenter.controllers.cland;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Contact;
import edu.vinaenter.models.Lands;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.util.PageUtil;

@Controller
public class ContactController {
	@Resource
	protected MessageSource messageSource;
	@Autowired
	private LandsService landsService;
	@Autowired
	private ContactService contactService;
	@Autowired
	CatService catService;

	@GetMapping("contact")
	public String contact(ModelMap modelMap,@RequestParam(required = false) String search) {
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		List<Lands> landsList = landsService.getLandListByView();
		modelMap.addAttribute("landsList", landsList);
		modelMap.addAttribute("catListHot", catService.getCatHot());
		List<Category> catList2 = catService.getAll2();
		modelMap.addAttribute("catList2", catList2);
		if (!"".equals(search) && search != null) {
			return "redirect:/index?search="+search;
		}
		return "cland.contact";
	}

	@PostMapping("contact")
	public String contact( @RequestParam(required = false) String search,ModelMap modelMap, @Valid @ModelAttribute("contact") Contact contact, BindingResult rs,
			RedirectAttributes rd) {
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		modelMap.addAttribute("catListHot", catService.getCatHot());
		List<Category> catList2 = catService.getAll2();
		modelMap.addAttribute("catList2", catList2);
		if (rs.hasErrors()) {
			System.out.println("Co' loi data");
			return "cland.contact";
		}
		if (contactService.save(contact) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/contact";
		}
		if (!"".equals(search) && search != null) {
			return "redirect:/index?search="+search;
		}
		rd.addFlashAttribute("err", messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "cland.contact";
	}

}
