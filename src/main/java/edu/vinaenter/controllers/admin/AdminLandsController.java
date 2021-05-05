package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Lands;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.util.FileUtil;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_NEWS)
public class AdminLandsController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	LandsService landsService;

	@Autowired
	CatService catService;

	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE, URLConstant.INDEX_SEARCH })

	// offset = (page -1)*rowCount
	public String index(Model model, @RequestParam(required = false) String search,
			@PathVariable(required = false) String page, Lands lands) {
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
		List<Lands> landsList = landsService.getAll(offset, GlobalConstant.TOTAL_ROW);
		int  totalPage = PageUtil.getTotalPage(landsService.totalRow());
		if (!"".equals(search) && search != null) {
			landsList = landsService.getSearch(search, offset, GlobalConstant.TOTAL_ROW);
			totalPage = PageUtil.getTotalPage(landsService.totalRowSearch(search));
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("landsList", landsList);
		model.addAttribute("search", search);
		return "admin.news.index";
	}

	@GetMapping(URLConstant.ADD)
	public String add(ModelMap modelMap) {
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		return "admin.news.add";
	}

	@PostMapping(URLConstant.ADD)
	public String cat(@Valid @ModelAttribute("lands") Lands lands, @RequestParam("file") MultipartFile file,
			HttpServletRequest request, BindingResult rs, RedirectAttributes rd) {
		String fileName = FileUtil.upload(file, request);
		System.out.println("khoa:"+fileName);
		lands.setPicture(fileName);
		if (rs.hasErrors()) {
			return "admin.news.add";
		}
		if (landsService.save(lands) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}

		return "admin.news.add";
	}

	@GetMapping(URLConstant.DELETE + "/{lid}")
	public String del(@PathVariable(value = "lid") int lid, @ModelAttribute("lands") Lands lands, BindingResult rs,
			RedirectAttributes rd) {
		if (landsService.del(lid) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("del.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}
		rd.addFlashAttribute("err", messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "admin.news.index";
	}

	@GetMapping(URLConstant.EDIT + "/{lid}")
	public String edit(Model model, @PathVariable(value = "lid") int lid, @ModelAttribute("lands") Lands lands,
			BindingResult rs, RedirectAttributes rd) {
		List<Category> catList = catService.getAll();
		model.addAttribute("catList", catList);
		Lands landFindId = landsService.findById(lid);
		model.addAttribute("landFindId", landFindId);
		return "admin.news.edit";
	}

	@PostMapping(URLConstant.EDIT + "/{lid}")
	public String edit(HttpServletRequest request, @ModelAttribute("lands") Lands lands, BindingResult rs,
			@RequestParam("file") MultipartFile file, RedirectAttributes rd) {
		String fileName = FileUtil.upload(file, request);
		lands.setPicture(fileName);
		if (landsService.update(lands) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("edit.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}
		return "admin.news.edit";
	}
}
