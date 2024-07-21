package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.practice.entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {
    @RequestMapping("/form")
    public String OpenForm(Model model) {
        System.out.println("Inside form");
        model.addAttribute("loginData", new LoginData());
        return "form";
    }

    // handler for process form
    @PostMapping("/process")
    public String ProcessForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "form";
        }

        System.out.println(loginData);
        return "success";
    }
}
