package com.inti.controller;


import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Concert;

import com.inti.model.Oeuvre;
import com.inti.model.Soliste;
import com.inti.repository.IChefOrchestreRepository;

import com.inti.model.Lieu;

import com.inti.repository.IConcertRepository;
import com.inti.repository.ILieuRepository;

import com.inti.repository.IOeuvreRepository;
import com.inti.repository.ISolisteRepository;


@Controller
public class ConcertController {

	@Autowired
	IConcertRepository icr;
	@Autowired
	ILieuRepository ilr;

	@Autowired
	IOeuvreRepository ior;
	@Autowired
	IChefOrchestreRepository icor;
	@Autowired
	ISolisteRepository isr;

	
	
	@GetMapping("creerConcert")
	public String ajoutConcert(Model m) {
		try {
			m.addAttribute("listeL", ilr.findAll());
			return "creerConcert";
		} catch (Exception e) {
			e.printStackTrace();
			return "creerConcert";
		}
		
	}
	
	@PostMapping("creerConcert")
	public String ajoutConcert(@RequestParam("nom") String nom, @RequestParam("date") LocalDate date, @RequestParam("lieu") int idlieu ) {
		Lieu l = ilr.getReferenceById(idlieu);
		Concert c= new Concert(nom, date);
		c.setLieu(l);
		icr.save(c);
		return "redirect:/listeConcert";
	}
	
	@GetMapping("listeConcert")
	public String Concert(Model m) {
//		System.out.println(icr.findAll());
		m.addAttribute("listeC", icr.findAll());
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
		public String modifierConcert(@ModelAttribute("concert")Concert c,@PathVariable("num")int num) {
		icr.save(c);
		return "redirect:/listeConcert";
	}
	
	
	//Infos concert
	
	@GetMapping("infoConcert/{num}")
	public String infoConcert(@PathVariable("num") int num, Model m) {
		
		m.addAttribute("lieu", ilr.getLieuConcert(num));
		
		//Récupère oeuvres
		List<Integer> listeIdOeuvre = ior.getOeuvreFromConcert(num);
		List<Oeuvre> listeOeuvre = new ArrayList<>();
		
		for(int i=0; i<listeIdOeuvre.size(); i++) {
			listeOeuvre.add(ior.getReferenceById(listeIdOeuvre.get(i)));
		}
		m.addAttribute("listeOeuvres", listeOeuvre);
//		m.addAttribute("ListeOeuvres", ior.getOeuvreFromConcert(num));
		
		m.addAttribute("chefOrchestre", icor.getChefByConcert(num));
		
		//Récupère solistes
		List<Integer> listeIdSoliste = isr.getSolistesByConcert(num);
		List<Soliste> listeSoliste = new ArrayList<>();
		
		for(int i=0; i<listeIdSoliste.size(); i++) {
			listeSoliste.add(isr.getReferenceById(listeIdSoliste.get(i)));
		}
		m.addAttribute("listeSolistes", listeSoliste);
		
	return "infoConcert";
	}
	
}
