package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Oeuvre;
import com.inti.repository.IOeuvreRepository;

@Controller
public class OeuvreController {
	
	@Autowired
	IOeuvreRepository ior;
	
	@GetMapping("ajoutOeuvre")
	public String ajoutOeuvre()
	{
		
		return "ajoutOeuvre";
	}
	
	@PostMapping("ajoutOeuvre")
	public String ajoutOeuvre(@ModelAttribute("oeuvre") Oeuvre o)
	{
		ior.save(o);
		return "redirect:/listeOeuvre";
	}
	
	@GetMapping("listeOeuvre")
	public String listeOeuvre(Model m)
	{
		
		m.addAttribute("listeO", ior.findAll());
		return "listeOeuvre";
	}
	
	@GetMapping("deleteOeuvre/{id}")
	public String deleteOeuvre(@PathVariable("id") int id)
	{
		Oeuvre o = ior.getReferenceById(id);
		ior.delete(o);
		return "redirect:/listeOeuvre";
	}
	
	@GetMapping("modifierOeuvre/{id}")
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

}
