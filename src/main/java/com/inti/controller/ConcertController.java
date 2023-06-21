package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Concert;
import com.inti.repository.IConcertRepository;

@Controller
public class ConcertController {

	@Autowired
	IConcertRepository icr;
	
	
	@GetMapping("creerConcert")
	public String ajoutConcert() {
		return "creerConcert";
	}
	
	@PostMapping("creerConcert")
	public String ajoutConcert(@ModelAttribute("concert")Concert c) {
		icr.save(c);
		return "listeConcert";
	}
	
	@GetMapping("listeConcert")
	public String Concert(Model m) {
		m.addAttribute("listeC", icr.findAll());
		System.out.println(icr.getConcertCount());
		m.addAttribute("nbA", icr.getConcertCount() );
		return "listeConcert";
	}
	
	@GetMapping("deleteConcert/{num}")
		public String deleteConcert(@PathVariable("num")int num) {
		Concert c=icr.getReferenceById(num);
		icr.delete(c);
		return "redirect:/listeConcert";
		}
	
	@GetMapping("modifierConcert/{num}")
		public String modifierConcert(@PathVariable("num")int num,Model m) {
		Concert c=icr.getReferenceById(num);
			m.addAttribute("c", c);
		return "modifierConcert";
	}
	
	@PostMapping("modifierConcert/{num}")
		public String modifierConcert(@ModelAttribute("concert")Concert c1,@PathVariable("num")int num) {
		icr.save(c1);
		return "listeConcert";		
	}
	
}
