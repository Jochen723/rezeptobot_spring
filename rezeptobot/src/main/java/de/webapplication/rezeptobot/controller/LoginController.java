package de.webapplication.rezeptobot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import de.webapplication.rezeptobot.models.User;
import de.webapplication.rezeptobot.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}

	@GetMapping("/registration")
	public ModelAndView showRegisterForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("registration");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	/**
	 * If User go directly to this Link, he will redirect to login
	 * @return
	 */
	@GetMapping("/process_register")
	public ModelAndView returnToLogin() {
		return new ModelAndView("redirect:/login");
	}

	@PostMapping("/process_register")
	public ModelAndView processRegister(User user) {
		ModelAndView modelAndView = new ModelAndView("register_success");
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String encodedPassword = passwordEncoder.encode(user.getPassword());
		// user.setPassword(encodedPassword);

		userService.save(user);

		return modelAndView;
	}

	@PostMapping("/process-login")
	public ModelAndView goToRecipeOverview() {
		return new ModelAndView("redirect:/uebersicht");
	}
}
