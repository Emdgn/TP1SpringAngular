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
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Soliste;
import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class SolisteController {

	@Autowired
	ISolisteRepository isr;
	
	
	@GetMapping("listeSoliste")
	public List<Soliste> listeSoliste() {
		return isr.findAll();
	}
	
	
	@PostMapping("enregistrerSoliste")
	public Soliste enregistrerSoliste(@RequestBody Soliste Soliste) {
		return isr.save(Soliste);
	}
	
	
	@DeleteMapping("supprimerSoliste/{idSoliste}")
	public boolean supprimerSoliste(@PathVariable("idSoliste") int idSoliste) {
		
		try {
			isr.findById(idSoliste).get();
			isr.delete(isr.getReferenceById(idSoliste));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	@PutMapping("modifierSoliste")
	public boolean modifierSoliste(@RequestBody Soliste Soliste) {
		if(isr.getReferenceById(Soliste.getIdSoliste()) != null) {
			isr.save(Soliste);
			return true;
		}
		
		return false;
	}

//	@GetMapping("enregistrerSoliste")
//	public String enregistrerSoliste() {
//		return "enregistrerSoliste";
//	}
//
//	@PostMapping("enregistrerSoliste")
//	public String enregistrerSoliste(@ModelAttribute("soliste") Soliste soliste) {
//		isr.save(soliste);
//		return "enregistrerSoliste";
//	}
//
//	@GetMapping("listeSoliste")
//	public String listeSoliste(Model m) {
//		m.addAttribute("listeSoliste", isr.findAll());
//		return "listeSoliste";
//	}
//
//	@DeleteMapping("supprimerSoliste/{idSoliste}")
//	public String supprimerSoliste(@PathVariable("idSoliste") int idSoliste) {
//		isr.delete(isr.getReferenceById(idSoliste));
//		return "redirect:/listeSoliste";
//	}
//
//	@GetMapping("modifierSoliste/{idSoliste}")
//	public String modifierSoliste(@PathVariable("idSoliste") int idSoliste, Model m) {
//		m.addAttribute("soliste", isr.getReferenceById(idSoliste));
//		return "modifierSoliste";
//	}
//
//	@PostMapping("modifierSoliste/{idSoliste}")
//	public String modifierSoliste(@PathVariable("idSoliste") int idSoliste, @ModelAttribute("soliste") Soliste soliste) {
//		isr.save(soliste);
//		return "redirect:/listeSoliste";
//	}


}
