package com.example.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springmvc.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// Add an initbinder to covert trim input settings
	// pre-process every String from data
	// Remove leading and trailing white space
	// If String contains only white space then it will return null. Resolve issue
	// for our validation
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerform";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		System.out.println("\n\nresult "+bindingResult);
		if (bindingResult.hasErrors()) {
			return "customerform";
		} else
			return "customer-confirmation";
	}

}
