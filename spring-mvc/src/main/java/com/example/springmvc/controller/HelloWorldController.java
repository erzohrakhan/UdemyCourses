package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	// need a controller method to show the initial HTML form
	@RequestMapping(value = "/showform", method = RequestMethod.GET)
	public String showForm() {
		return "helloworld_form";
	}

	// need a controller method to process the form
	@RequestMapping(value = "/processform", method = RequestMethod.POST)
	public String processForm() {
		return "hello";
	}

	// Controller to read from data and add data to model
	@RequestMapping(value = "/processform3", method = RequestMethod.POST)
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {

		// convert the data to all caps and create message
		String result = "Welcome " + theName.toUpperCase();
		model.addAttribute("message", result);
		return "hello";
	}
}
