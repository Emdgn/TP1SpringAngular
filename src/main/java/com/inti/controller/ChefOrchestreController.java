package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.ChefOrchestre;
import com.inti.repository.IChefOrchestreRepository;

@Controller
public class ChefOrchestreController {

	@Autowired
	IChefOrchestreRepository icor;

//Create
	@GetMapping("/ajouterChef")
	public String afficherFormulaireAjout(Model model) {
		model.addAttribute("chef", new ChefOrchestre());
		return "ajoutChef";
	}

	@PostMapping("/ajouterChef")
	public String ajouterChef(@ModelAttribute ChefOrchestre chef) {
		icor.save(chef);
		return "redirect:/liste";
	}

//Read
	@GetMapping("/liste")
	public String afficherListeChefs(Model model) {
		model.addAttribute("chefs", icor.findAll());
		return "listeChefs";
	}

//Update
	@GetMapping("/modifierChef/{numChef}")
	public String afficherFormulaireModification(@PathVariable("numChef") int id, Model model) {
		model.addAttribute("c1", icor.getReferenceById(id));
		return "modifierChef";
	}

	@PostMapping("/modifierChef/{numChef}")
	public String modifierChef(@PathVariable("numChef") int id, @ModelAttribute ChefOrchestre chef) {
		icor.save(chef);
		return "redirect:/liste";
	}

//Delete
	@GetMapping("/supprimerChef/{id}")
	public String supprimerChef(@PathVariable("id") int id) {
		icor.deleteById(id);
		return "redirect:/liste";
	}
}
