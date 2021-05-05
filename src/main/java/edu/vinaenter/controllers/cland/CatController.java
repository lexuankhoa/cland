package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Lands;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.util.PageUtil;

@Controller
public class CatController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	LandsService landsService;

	@Autowired
	CatService catService;

	@GetMapping("cat" + "/{cid}" + "/{page}")
	public String index( @RequestParam(required = false) String search,@PathVariable(value = "cid") int cid, Model model,

			@PathVariable(required = false) String page, ModelMap modelMap, Lands lands) {
		List<Lands> landsList = landsService.getLandListByView();
		modelMap.addAttribute("landsList", landsList);
		List<Category> catList = catService.getAll();
		List<Category> catList2 = catService.getAll2();
		model.addAttribute("catList2", catList2);
		model.addAttribute("catList", catList);
		model.addAttribute("catListHot", catService.getCatHot());
		model.addAttribute("nameCat",catService.getName(cid));
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
		List<Lands> getByCatId = landsService.getAll(cid, offset, GlobalConstant.TOTAL_ROW);
		if (!"".equals(search) && search != null) {
			return "redirect:/index?search="+search;
		}
		model.addAttribute("totalPage", PageUtil.getTotalPage(landsService.totalRow()));
		model.addAttribute("currentPage", page);
		model.addAttribute("getByCatId", getByCatId);
		return "cland.cat";
	}
}
