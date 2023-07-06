package com.inti.controller;


import com.inti.model.Lieu;

import com.inti.repository.ILieuRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LieuController {

    @Autowired
    private ILieuRepository ilr;

	@GetMapping("hello")
	private String hello()
	{
		return "Hello World !";
	}
	
	@GetMapping("listeLieu")
	public List<Lieu> listeLieu()
	{
		return ilr.findAll();
	}
	
	@PostMapping("saveLieu")
	public Lieu saveLieu(@RequestBody Lieu Lieu)
	{
		return ilr.save(Lieu);
	}
	
	@PutMapping("modifierLieu")
	public boolean modifierLieu(@RequestBody Lieu e)
	{
		if(ilr.getReferenceById(e.getId())!=null)
		{
		ilr.save(e);
		return true;
		}
	return false;
	}
	
	@DeleteMapping("deleteLieu/{id}")
	public boolean deleteLieu(@PathVariable("id") int id)
	{
		try 
		{
			ilr.findById(id).get();
			Lieu Lieu1 = ilr.getReferenceById(id);
			ilr.delete(Lieu1);
			
			return true;
			
		}catch(Exception e1)
		
		{
			return false;
		}
	}
}
