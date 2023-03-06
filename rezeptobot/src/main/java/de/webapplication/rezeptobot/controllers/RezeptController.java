package de.webapplication.rezeptobot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RezeptController {

	@GetMapping("/uebersicht")
	public ModelAndView getAllRecipes() {
		ModelAndView modelAndView = new ModelAndView("/uebersicht");

		return modelAndView;
	}
}
