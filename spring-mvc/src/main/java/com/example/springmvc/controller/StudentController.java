package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springmvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
@RequestMapping("/showform")
	public String showForm(Model theModel) {
		// Create a student object
		Student student = new Student();
		// add student object to the model
		theModel.addAttribute("student", student);

		return "studentform";
	}

	@RequestMapping("/processform")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("First name " + theStudent.getFirstName() + "\t Last name " + theStudent.getFirstName());
		return "studentconfirmation";
	}
}
