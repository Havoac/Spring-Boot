package com.practice.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	// handling iteration
	@RequestMapping("/example-loop")
	public String IterateHandler(Model m) {
		// create a list, set collection
		List<String> names = List.of("Aman", "Laxmi", "Jack");
		m.addAttribute("ns", names);
		return "iterate";
	}

	// handling conditional statements
	@GetMapping("/condition")
	public String ConditionalHandler(Model m) {
		m.addAttribute("gender", "M");

		List<Integer> list = List.of(1, 2, 3, 4);
		m.addAttribute("list", list);

		return "condition";
	}

	// handler for including fragments
	@GetMapping("/service")
	public String ServicesHandler(Model m) {
		m.addAttribute("title", "I like golgappe");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		return "service";
	}

	// for new about
	@GetMapping("/newabout")
	public String NewAbout() {
		return "aboutnew";
	}

	// for contact
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
}
