package de.webapplication.rezeptobot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

	@GetMapping("/rezeptplaner")
	public ModelAndView getRezeptkalender() {
		return new ModelAndView("/rezeptplaner");
	}
}
