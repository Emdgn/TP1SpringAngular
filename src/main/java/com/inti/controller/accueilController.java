package com.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class accueilController {
		
	@GetMapping("/")
	public String accueil(Model model) {
		return "accueil";
	}
}
