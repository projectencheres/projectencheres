package fr.eni.projet_encheres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.projet_encheres.bll.ArticleService;

@Controller
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService _articleService) {
        this.articleService = _articleService;
    }

    @GetMapping("/creation-vente")
    public String creationVente(Model model) {
        System.out.println("test");
        return "produits/enregistrement-produit";
    }
}
