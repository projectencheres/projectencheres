package fr.eni.projet_encheres.controllers;

import fr.eni.projet_encheres.bll.EnchereService;
import fr.eni.projet_encheres.bo.Enchere;

import java.util.List;

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

    // @PostMapping("/encheres/filtre")
    // public String homePageFiltered(Model model, @RequestParam("filter_query") String filter_query, @RequestParam("filter_categorie") String filter_categorie) {
    //     model.addAttribute("encheres", enchereService.findByName(filter_query));
    //     return "index";
    // }

    @PostMapping("/encheres/filtre")
    public String homePageFiltered(Model model, @RequestParam("filter_query") String filter_query, @RequestParam("filter_categorie") int filter_categorie) {
        System.out.println(filter_categorie);
        if (!filter_query.isEmpty() && filter_categorie != 0) {
            model.addAttribute("encheres", enchereService.findByNameAndCategorie(filter_query, filter_categorie));
        } else if (!filter_query.isEmpty()) {
            model.addAttribute("encheres", enchereService.findByName(filter_query));
        } else if (filter_categorie != 0) {
            model.addAttribute("encheres", enchereService.findByCategorie(filter_categorie));
        } else {
            return "redirect:/encheres";
        }
        return "index";
    }

    
}
