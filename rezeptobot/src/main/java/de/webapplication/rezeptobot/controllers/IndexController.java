package de.webapplication.rezeptobot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("login");

		// Iterable<User> users = userService.getAll();
		// modelAndView.addObject("users", userService.getAll());
		return modelAndView;
	}
}
