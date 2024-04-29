package fr.eni.projet_encheres.security;

import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.dal.UtilisateurRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncheresUserDetailsService implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;

    public EncheresUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifiant) throws UsernameNotFoundException {

        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByPseudoOrEmail(identifiant);

        if (optionalUtilisateur.isEmpty()) {
            throw new UsernameNotFoundException("User with identifiant: " + identifiant + "not found");
        }

        Utilisateur utilisateur = optionalUtilisateur.get();

        UserBuilder userBuilder = User.builder()
                .username(utilisateur.getEmail())
                .password(utilisateur.getMotDePasse());

        if (utilisateur.getAdministrateur()) {
            userBuilder = userBuilder.roles("admin", "user");
        } else {
            userBuilder = userBuilder.roles("user");

        }
        return userBuilder.build();
    }
}
