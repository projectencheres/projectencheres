package fr.eni.projet_encheres.controllers;

import fr.eni.projet_encheres.bll.UtilisateurService;
import fr.eni.projet_encheres.bo.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import java.util.Optional;


@Controller
@RequestMapping("/inscription")
public class RegistrationController {

    private final UtilisateurService utilisateurService;

    public RegistrationController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateurs/registration";
    }

    @PostMapping
    public String registerUtilisateur(
            @ModelAttribute("utilisateur") @Valid Utilisateur utilisateur,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "utilisateurs/registration";
        }

        utilisateurService.save(utilisateur);
        return "redirect:/index";
    }
}
