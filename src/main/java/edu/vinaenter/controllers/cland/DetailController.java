package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Lands;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.util.PageUtil;

@Controller
public class DetailController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	LandsService landsService;

	@Autowired
	CatService catService;

	@GetMapping("detail" + "/{lid}")
	public String detail(  @RequestParam(required = false) String search,ModelMap modelMap,
			@PathVariable(value = "lid") int lid, @ModelAttribute("lands") Lands lands, BindingResult rs,
			RedirectAttributes rd) {
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		modelMap.addAttribute("catListHot", catService.getCatHot());
		List<Lands> landsList = landsService.getLandListByView();
		modelMap.addAttribute("landsList", landsList);
		Lands landsList1 = landsService.findById(lid);
		int newCountView = landsList1.getCount_views() + 1;
		if (landsService.updateCountView(newCountView, landsList1.getLid()) > 0) {
			landsList1.setCount_views(newCountView);
		}
		modelMap.addAttribute("landsList1", landsList1);
		if (!"".equals(search) && search != null) {
			return "redirect:/index?search="+search;
		}
		modelMap.addAttribute("totalrow", PageUtil.getTotalPage(landsService.totalRow()));
		List<Category> catList2 = catService.getAll2();
		modelMap.addAttribute("catList2", catList2);
		return "cland.detail";
	}
}
