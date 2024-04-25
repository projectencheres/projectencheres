package fr.eni.projet_encheres.controllers;

import fr.eni.projet_encheres.bll.EnchereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnchereController {

    private EnchereService enchereService;

    public EnchereController(EnchereService enchereService) {
        this.enchereService = enchereService;
    }

    @GetMapping("/encheres")
    public String homePageView(Model model) {
        model.addAttribute("encheres", enchereService.findAllEncheres());
        return "index";
    }

    @PostMapping("/encheres/filtre")
    public String homePageFiltered(Model model, @RequestParam("motCle") String motCle, @RequestParam("categorie") String categorie) {
        model.addAttribute("encheres", enchereService.findAllEncheres());
        return "index";
    }
    
}
