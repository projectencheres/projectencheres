package fr.eni.projet_encheres.security;

import fr.eni.projet_encheres.dal.UtilisateurRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests.requestMatchers("/encheres").permitAll()
                .requestMatchers("/inscription").permitAll()
                .requestMatchers("/css/**", "/img/**", "/fonts/**").permitAll()
                .requestMatchers("/utilisateurs/**").hasAnyRole("user", "admin")
                .requestMatchers("/**").permitAll()
                // .requestMatchers("/utilisateurs/{id}/voir", "/utilisateurs/{id}/modifier",
                // "/utilisateurs/{id}/supprimer").authenticated()
                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").permitAll())
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public EncheresUserDetailsService encheresUserDetailsService(UtilisateurRepository utilisateurRepository) {
        return new EncheresUserDetailsService(utilisateurRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
