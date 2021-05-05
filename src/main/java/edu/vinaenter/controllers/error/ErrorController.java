package edu.vinaenter.controllers.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.constant.URLConstant;

@Controller
@RequestMapping(URLConstant.URL_ERROR)
public class ErrorController {
	@GetMapping(URLConstant.ERR_403)
 public String E403() {
	 
	 return "error.403";
 }
	@GetMapping(URLConstant.ERR_404)
 public String E404() {
	 
	 return "error.404";
 }
}
