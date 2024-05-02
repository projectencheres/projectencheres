package fr.eni.projet_encheres.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.projet_encheres.bll.ArticleService;
import fr.eni.projet_encheres.bll.CategorieService;
import fr.eni.projet_encheres.bll.UtilisateurService;
import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.bo.Retrait;
import fr.eni.projet_encheres.bo.Utilisateur;
import jakarta.validation.Valid;

@Controller
public class ArticleController {

    private ArticleService articleService;
    private CategorieService categorieService;
    private UtilisateurService utilisateurService;

    public ArticleController(ArticleService _articleService, CategorieService _categorieService,
            UtilisateurService _utilisateurService) {
        this.articleService = _articleService;
        this.categorieService = _categorieService;
        this.utilisateurService = _utilisateurService;
    }

    @GetMapping("/creation-vente")
    public String creationVente(Model model) {
        Optional<Utilisateur> utilisateurOptional = utilisateurService.findByPseudoOrEmail("test");
        Utilisateur utilisateur = utilisateurOptional.get();
        System.out.println(utilisateur);
        Retrait retrait = new Retrait(utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille());

        Article article = new Article();
        article.setRetrait(retrait);

        System.out.println(article);

        model.addAttribute("article", article);
        model.addAttribute("categorieList", categorieService.findAll());

        return "produits/enregistrement-produit";
    }

    @PostMapping("/ajoutArticle")
    public String ajoutFilm(@Valid @ModelAttribute Article article, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "produits/enregistrement-produit";
        }
        articleService.save(article);
        return "redirect:/encheres";
    }
}
