package com.example.zavodliva.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.zavodliva.user.entity.User;
import com.example.zavodliva.user.service.UserServiceImpl;


@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	
	@GetMapping("/registerNewAdminForKvecherina")
	public String registerPage(Model model) {
		
		model.addAttribute("user", new User());
		
		return "registrationForm";
	}
	

}
