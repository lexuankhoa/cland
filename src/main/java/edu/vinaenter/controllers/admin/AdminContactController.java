package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Contact;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CONTACT)
public class AdminContactController {
	@Autowired
	 MessageSource messageSource;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE, URLConstant.INDEX_SEARCH })
	public String index(Model model, @RequestParam(required = false) String search,
			@PathVariable(required = false) String page, Contact contact) {
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
		int  totalPage = PageUtil.getTotalPage(contactService.totalRow());
		System.out.println("fdsjfhjsf" + search);
		List<Contact> contactList = contactService.getAll(offset, GlobalConstant.TOTAL_ROW);
		if (!"".equals(search) && search != null) {
			contactList = contactService.getSearch(search, offset, GlobalConstant.TOTAL_ROW);
			totalPage = PageUtil.getTotalPage(contactService.totalRowSearch(search));
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("contactList", contactList);
		model.addAttribute("search", search);
		return "admin.contact.index";
	}
	
	@GetMapping(URLConstant.DELETE +"/{ct_id}")
	public String del(@PathVariable(value="ct_id") int ct_id, RedirectAttributes rd) {
		if(contactService.del(ct_id) > 0) {
			rd.addFlashAttribute("msg",messageSource.getMessage("del.success", null, Locale.getDefault()));
			return "redirect:/admin/contact/index";
		}
		rd.addFlashAttribute("err",messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "admin.contact.index";
	}

}
