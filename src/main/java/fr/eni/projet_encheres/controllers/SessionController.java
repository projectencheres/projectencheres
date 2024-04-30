package fr.eni.projet_encheres.controllers;

import fr.eni.projet_encheres.bll.UtilisateurService;
import fr.eni.projet_encheres.bo.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Optional;

@Controller
public class SessionController {

    private final UtilisateurService utilisateurService;

    public SessionController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/inscription")
    public String showRegistrationForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "security/registration";
    }

    @PostMapping("/inscription")
    public String registerUtilisateur(
            @Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
            @RequestParam("motDePasseConfirmation") String motDePasseConfirmation,
            @RequestParam("action") String action,
            Model model,
            BindingResult result) {

        System.out.println(utilisateur);

        if (result.hasErrors()) {
            return "security/registration";
        }

        Optional<Utilisateur> existingUtilisateurPseudo = utilisateurService
                .findByPseudoOrEmail(utilisateur.getPseudo());
        Optional<Utilisateur> existingUtilisateurEmail = utilisateurService.findByPseudoOrEmail(utilisateur.getEmail());

        if ((existingUtilisateurPseudo.isPresent()) || (existingUtilisateurEmail.isPresent())) {
            model.addAttribute("pseudoOrEmailError", "Pseudo or email exists already. Please log in instead");
            return "security/registration";
        }

        if (!utilisateur.getMotDePasse().equals(motDePasseConfirmation)) {
            model.addAttribute("passwordMismatch", true);
            return "security/registration";
        }

        if ("create".equals(action)) {
            utilisateur.setCredit(0.0);
            utilisateur.setMotDePasse(new BCryptPasswordEncoder().encode(utilisateur.getMotDePasse()));
            utilisateurService.save(utilisateur);
            return "redirect:/encheres";
        } else if ("cancel".equals(action)) {
            return "redirect:/encheres";
        }

        utilisateur.setCredit(0.0);
        utilisateurService.save(utilisateur);
        return "redirect:/encheres";
    }

    @GetMapping("/login")
    public String login() {
        return "security/login";
    }
}
