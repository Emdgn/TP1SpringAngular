package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inti.model.ChefOrchestre;
import com.inti.repository.IChefOrchestreRepository;



@RestController

//@RequestMapping("ChefOrchestreRestControl")

@CrossOrigin(origins = "http://localhost:4200")

public class ChefOrchestreController {

	@Autowired
	IChefOrchestreRepository icor;
	
	

	@GetMapping("/getListeChefOrchestres")
	public List<ChefOrchestre> getListeChefOrchestres(){
		
		return icor.findAll();
	}
	
	
	@GetMapping("/getChefOrchestre/{id}")
	public ChefOrchestre getChefOrchestre(@PathVariable("id") int id) {
		
		System.out.println("id : " + id);
		try {
			
			ChefOrchestre c = icor.getReferenceById(id);
			return c;
		} catch (Exception e) {
			return null;
		}
	}
	
	@PutMapping("/modifierChefOrchestre")
	public boolean modifierChefOrchestre(@RequestBody ChefOrchestre c) {
		
		if(icor.getReferenceById(c.getNumChef()) != null ) {
			icor.save(c);
			return true;
		}
		return false;
	}	
	
	
	
	
	
	@PostMapping("/ajoutChefOrchestre")
	public ChefOrchestre saveChefOrchestre(@RequestBody ChefOrchestre c) {
		return icor.save(c);
	}
	


	
	
	@DeleteMapping("/supprimerChefOrchestre/{id}")
	public boolean deleteChefOrchestre(@PathVariable("id") int id) {
		
		try {

			ChefOrchestre c = icor.findById(id).get();
			icor.delete(c);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	

////Create
//	@GetMapping("/ajouterChef")
//	public String afficherFormulaireAjout(Model model) {
//		model.addAttribute("chef", new ChefOrchestre());
//		return "ajoutChef";
//	}
//
//	@PostMapping("/ajouterChef")
//	public String ajouterChef(@ModelAttribute ChefOrchestre chef) {
//		icor.save(chef);
//		return "redirect:/liste";
//	}
//
////Read
//	@GetMapping("/liste")
//	public String afficherListeChefs(Model model) {
//		model.addAttribute("chefs", icor.findAll());
//		return "listeChefs";
//	}
//
////Update
//	@GetMapping("/modifierChef/{numChef}")
//	public String afficherFormulaireModification(@PathVariable("numChef") int id, Model model) {
//		model.addAttribute("c1", icor.getReferenceById(id));
//		return "modifierChef";
//	}
//
//	@PostMapping("/modifierChef/{numChef}")
//	public String modifierChef(@PathVariable("numChef") int id, @ModelAttribute ChefOrchestre chef) {
//		icor.save(chef);
//		return "redirect:/liste";
//	}
//
////Delete
//	@GetMapping("/supprimerChef/{id}")
//	public String supprimerChef(@PathVariable("id") int id) {
//		icor.deleteById(id);
//		return "redirect:/liste";
//	}
}
