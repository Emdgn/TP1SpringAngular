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
	
	@GetMapping("deleteActeur/{id}")
		public String deleteConcert(@PathVariable("id")int id) {
		Concert c=icr.getReferenceById(id);
		icr.delete(c);
		return "redirect:/listeConcert";
		}
	
	@GetMapping("modifierConcert/{id}")
		public String modifierConcert(@PathVariable("id")int id,Model m) {
		Concert c=icr.getReferenceById(id);
			m.addAttribute("c", c);
		return "modifierConcert";
	}
	
	@PostMapping("modifierConcert/{id}")
		public String modifierConcert(@ModelAttribute("concert")Concert c1,@PathVariable("id")int id) {
		icr.save(c1);
		return "listeConcert";		
	}
	
}
