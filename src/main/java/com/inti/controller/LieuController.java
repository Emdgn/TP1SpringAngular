package com.inti.controller;

import com.inti.model.Concert;
import com.inti.model.Lieu;
import com.inti.repository.ILieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LieuController {

    @Autowired
    private ILieuRepository ilr;

    @GetMapping("listeLieux")
    public String getAllLieux(Model model) {
        List<Lieu> lieux = ilr.findAll();
        model.addAttribute("lieux", lieux);
        return "lieux";
    }

    @GetMapping("ajouterLieu")
    public String addLieu(Model model) {
        Lieu lieu = new Lieu();
        model.addAttribute("lieu", lieu);
        return "ajoutLieu";
    }

    @PostMapping("ajouterLieu")
    public String addLieu(@ModelAttribute("lieu") Lieu lieu) {
        ilr.save(lieu);
        return "redirect:/lieux";
    }
    
    @GetMapping("/lieux/{id}")
    public String afficherConcertsLieu(@PathVariable("id") int lieuId, Model model) {
        List<Concert> concerts = ilr.getConcertsByLieuId(lieuId);
        Lieu lieu = ilr.findById(lieuId).orElse(null);
        model.addAttribute("lieu", lieu);
        model.addAttribute("concerts", concerts);
        return "concerts_lieu";
    }

    
}
