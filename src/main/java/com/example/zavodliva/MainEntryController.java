package com.example.zavodliva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zavodliva.resourse.ShowService;
import com.example.zavodliva.user.entity.User;
import com.example.zavodliva.user.entity.UserRepository;
import com.example.zavodliva.user.errors.EmailAllreadyExistExceptionMessage;
import com.example.zavodliva.user.errors.InvalidPasswordException;
import com.example.zavodliva.user.service.UserServiceImpl;
import com.example.zavodliva.user.service.UsersDetails;

@Controller
public class MainEntryController {
	
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ShowService showService;
	
	@Autowired
	UserServiceImpl service;

	@GetMapping("/")
	public String getIndexPage(Model model,@AuthenticationPrincipal UsersDetails user) {
		
		model.addAttribute("show", showService.lastShow());
		if(user != null) {
		String userEmail = user.getUsername();
        User user1 = userRepository.findByEmail(userEmail);
           model.addAttribute("user", user1);
		}
		return "index";
	}
	
	@GetMapping("/login")
	public String getloginPage(Model model,@AuthenticationPrincipal UsersDetails user) {
		if(user != null) {
			String userEmail = user.getUsername();
	        User user1 = userRepository.findByEmail(userEmail);
	           model.addAttribute("user", user1);
			}
		return "redirect:/";
	}
	
	@GetMapping("/logoutSuccess")
	public String logout() {
		return "redirect:/";
	}
	
	@GetMapping("/admin")
	public String administration(Model model) {
		
		return "administration";
	}
	
	@PostMapping("/registerNewAdminForKvecherina")
	public String completeRegistration(@ModelAttribute(value = "user")User user, Model model) {
		
		try {
			service.registerNewUser(user);
		} catch (InvalidPasswordException | EmailAllreadyExistExceptionMessage e) {
			model.addAttribute("error", e.getMessage());
			return "registrationForm";
		}
		
		return "redirect:/";
	}
	
	
}
