package com.example.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/processform2", method = RequestMethod.POST)
	public String letsShoutDude(HttpServletRequest req, Model model) {

		// read the request parameter from html
		String theName = req.getParameter("studentName");
		// convert the data to all caps and create message
		String result = "Yo! " + theName.toUpperCase();
		model.addAttribute("message", result);
		return "hello";
	}
}
