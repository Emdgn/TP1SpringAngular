package com.inti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Oeuvre;
import com.inti.repository.IOeuvreRepository;

@RestController
@RequestMapping("/oeuvre")
@CrossOrigin(origins = "http://localhost:4200")
public class OeuvreController {
	@Autowired
	IOeuvreRepository oeuvreRepository;
	
	@PostMapping("/create")
  public Boolean createOeuvre(@RequestBody Oeuvre oeuvre) {
		System.out.println(oeuvre);
		try {
      oeuvreRepository.save(oeuvre);
      return true;
	  } catch (Exception e) {
	      return false;
	  }
  }
	
	@GetMapping("/get")
	public List<Oeuvre> getOeuvres() {
		return oeuvreRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Oeuvre> getOeuvre(@PathVariable("id") String id) {
		return oeuvreRepository.findById(Integer.parseInt(id));
	}
	
	@PutMapping("/update/{id}")
  public Boolean updateOeuvre(@PathVariable("id") String id, @RequestBody Oeuvre oeuvre) {
    Optional<Oeuvre> oeuvreOptional = oeuvreRepository.findById(Integer.parseInt(id));

    if (oeuvreOptional.isPresent()) {
    	oeuvreRepository.save(oeuvre);
      return true;
    }
    return false;
  }
	
	@DeleteMapping("/delete/{id}")
  public Boolean deleteOeuvre(@PathVariable("id") String id) {
    Optional<Oeuvre> oeuvreOptional = oeuvreRepository.findById(Integer.parseInt(id));

    if (oeuvreOptional.isPresent()) {
        oeuvreRepository.delete(oeuvreOptional.get());
        return true;
    }
    return false;
  }
}
