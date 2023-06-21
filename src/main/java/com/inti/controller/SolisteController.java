package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

@Controller
public class SolisteController {

	@Autowired
	ISolisteRepository isr;

	@GetMapping("enregistrerSoliste")
	public String enregistrerSoliste() {
		return "enregistrerSoliste";
	}

	@PostMapping("enregistrerSoliste")
	public String enregistrerSoliste(@ModelAttribute("soliste") Soliste soliste) {
		isr.save(soliste);
		return "enregistrerSoliste";
	}

	@GetMapping("listeSoliste")
	public String listeSoliste(Model m) {
		m.addAttribute("listeSoliste", isr.findAll());
		return "listeSoliste";
	}

	@GetMapping("supprimerSoliste/{idSoliste}")
	public String supprimerSoliste(@PathVariable("idSoliste") int idSoliste) {
		isr.delete(isr.getReferenceById(idSoliste));
		return "redirect:/listeSoliste";
	}

	@GetMapping("modifierSoliste/{idSoliste}")
	public String modifierSoliste(@PathVariable("idSoliste") int idSoliste, Model m) {
		m.addAttribute("soliste", isr.getReferenceById(idSoliste));
		return "modifierSoliste";
	}

	@PostMapping("modifierSoliste/{idSoliste}")
	public String modifierSoliste(@PathVariable("idSoliste") int idSoliste, @ModelAttribute("soliste") Soliste soliste) {
		isr.save(soliste);
		return "redirect:/listeSoliste";
	}
	
	/***
	 * @GetMapping("modifierOeuvre/{id}")
	public String modifierOeuvre(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("o1", ior.getReferenceById(id));
		
		return "modifierOeuvre";
	}
	
	@PostMapping("modifierOeuvre/{id}")
	public String updateOeuvre(@PathVariable("id") int id, @ModelAttribute("oeuvre") Oeuvre o)
	{
		ior.save(o);
		
		return "redirect:/listeOeuvre";
	}
	 * 
	 * 
	 * 
	 */

}
