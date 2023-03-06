package de.webapplication.rezeptobot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import de.webapplication.rezeptobot.models.User;
import de.webapplication.rezeptobot.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String showForm() {
		return "login";
	}

	@GetMapping("/registrieren")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "registrieren";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		System.out.println("test");
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String encodedPassword = passwordEncoder.encode(user.getPassword());
		// user.setPassword(encodedPassword);

		// userService.save(user);
		// System.out.println("Encoded password is " + user.getPassword());

		// userRepo.save(user);

		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
	    Iterable<User> listUsers = userService.getAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
}