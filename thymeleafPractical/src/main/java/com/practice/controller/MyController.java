package com.practice.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String About(Model model) {
		System.out.println("Inside about handler");

		model.addAttribute("name", "Shivansh");
		model.addAttribute("currentDate", new Date().toLocaleString());

		return "about"; // about.html
	}
}
