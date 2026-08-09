package edu.vinaenter.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestPassController {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/pass")
	@ResponseBody
	public String index() {
		return passwordEncoder.encode("1");
	}
}
