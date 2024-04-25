package fr.eni.projet_encheres.controllers;

import fr.eni.projet_encheres.bll.UtilisateurService;
import fr.eni.projet_encheres.bo.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

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
            @Valid
            @ModelAttribute("utilisateur")  Utilisateur utilisateur,
            @RequestParam("motDePasseConfirmation") String motDePasseConfirmation,
            Model model,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "utilisateurs/registration";
        }

        if(!utilisateur.getMotDePasse().equals(motDePasseConfirmation)) {
            model.addAttribute("passwordMismatch", true);
            return "utilisateurs/registration";
        }

        utilisateur.setCredit(0.0);

        utilisateurService.save(utilisateur);
        return "redirect:/encheres";
    }
}
