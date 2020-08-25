package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/main")
	public String showPage() {
		return "main-menu";
	}

}
