package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Lands;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.util.PageUtil;

@Controller
public class ClandController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	LandsService landsService;

	@Autowired
	CatService catService;

	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE, URLConstant.INDEX_SEARCH })

	public String index(Model model, @RequestParam(required = false) String search,
			@PathVariable(required = false) String page, Lands lands) {
		List<Category> catList = catService.getAll();
		List<Category> catList2 = catService.getAll2();
		model.addAttribute("catListHot", catService.getCatHot());
		model.addAttribute("catList", catList);
		model.addAttribute("catList2", catList2);
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
		int totalPage = PageUtil.getTotalPage(landsService.totalRow());
		if (!"".equals(search) && search != null) {
			landsList = landsService.getSearch(search, offset, GlobalConstant.TOTAL_ROW);
			totalPage = PageUtil.getTotalPage(landsService.totalRowSearch(search));
		}
		List<Lands> landsList1 = landsService.getLandListByView();
		model.addAttribute("landsList", landsList1);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("landsList1", landsList);
		model.addAttribute("search", search);
		return "cland.index";
	}
	@GetMapping("/*")
	public String index() {
		
		return "redirect:/index";
	}
}
