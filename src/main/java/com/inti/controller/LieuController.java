package com.inti.controller;

import com.inti.model.Lieu;
import com.inti.repository.ILieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LieuController {

    @Autowired
    private ILieuRepository ilr;

    @GetMapping("/lieux")
    public String getAllLieux(Model model) {
        List<Lieu> lieux = ilr.findAll();
        model.addAttribute("lieux", lieux);
        return "listeLieux";
    }

    @GetMapping("/lieux/ajouter")
    public String addLieu(Model model) {
        Lieu lieu = new Lieu();
        model.addAttribute("lieu", lieu);
        return "ajoutLieu";
    }

    @PostMapping("/lieux/ajouter")
    public String addLieu(@ModelAttribute("lieu") Lieu lieu) {
        ilr.save(lieu);
        return "redirect:/lieux";
    }
}
