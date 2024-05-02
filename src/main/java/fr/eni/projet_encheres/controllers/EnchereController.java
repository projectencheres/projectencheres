package fr.eni.projet_encheres.controllers;

import fr.eni.projet_encheres.bll.EnchereService;
import fr.eni.projet_encheres.bo.Enchere;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String homePageFiltered(Model model, @RequestParam("filter_query") String filter_query,
            @RequestParam("filter_categorie") int filter_categorie) {
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

    @GetMapping("/article/{noEnchere}/encherir")
    public String displayArticle(@PathVariable("noEnchere") int noEnchere, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Map<String, Object> enchereMap = enchereService.customFindById(noEnchere, currentPrincipalName);
        model.addAttribute("enchereMap", enchereMap);
        System.out.println(enchereMap);

        if (enchereMap != null) {
            Object miseAPrixObj = enchereMap.get("mise_a_prix");
            Object sessionUserCreditObj = enchereMap.get("session_user_credit");

            // convert from object back to double

            if ((miseAPrixObj instanceof Double) && (sessionUserCreditObj instanceof Double)) {
                double miseAPrix = ((Number) miseAPrixObj).doubleValue();
                double sessionUserCredit = ((Number) sessionUserCreditObj).doubleValue();

                if (sessionUserCredit >= miseAPrix) {
                    model.addAttribute("encherePossible", true);
                    model.addAttribute("maProposition", sessionUserCredit);
                } else {
                    model.addAttribute("encherePossible", false);
                    model.addAttribute("errorMessage", "You don't have enough points to place a bid on this item.");
                }
            } else {
                model.addAttribute("encherePossible", false);
                model.addAttribute("errorMessage", "Unable to retrieve item details. Please try again later.");
            }
        } else {
            model.addAttribute("encherePossible", false);
            model.addAttribute("errorMessage", "Unable to retrieve item details. Please try again later.");
        }
        return "produits/encherir_produit";
    }

}
