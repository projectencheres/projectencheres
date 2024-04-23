package fr.eni.projet_encheres;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.bo.Utilisateur;
import fr.eni.projet_encheres.dal.ArticleRepository;
import fr.eni.projet_encheres.dal.UtilisateurRepository;

@Component
public class TestSql implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository repoUtilisateur;

	@Autowired
	private ArticleRepository repoArticle;
	
	@Override
	public void run(String... args) throws Exception {

		// ----------- Utilisateur TEST ----------- //
		System.out.println("Test de find all users : ");
		List<Utilisateur> utilisateurs = repoUtilisateur.findAll();
		System.out.println(utilisateurs);
		
		
		// System.out.println("Test de find user by id : ");
		// Optional<Utilisateur> utilisateur = repoUtilisateur.findById(2);
		// System.out.println(utilisateur);
		
		// Utilisateur utilisateurTest = new Utilisateur(3, "Jdoe", "Doe", "John", "josédoe@example.com", "0123456789", "123 Main St", "75001", "Paris", "password123", 100.00, false);
		// repoUtilisateur.save(utilisateurTest);
		// System.out.println(utilisateurTest);
		
		// Utilisateur utilisateurTest2 =  new Utilisateur(4, "Jadoe", "Doe", "Janne", "jannedoe@example.com", "0123456789", "anonym", "75001", "Paris", "password123", 101.00, false);
		// repoUtilisateur.update(utilisateurTest2);
		// System.out.println(utilisateurTest2);

        // List<Utilisateur> finalUtilisateurs = repoUtilisateur.findAll();
		// System.out.println(finalUtilisateurs);

		// -------------  Article Test  ------------- //
		System.out.println("Test de find all articles : ");
		List<Article> articles = repoArticle.findAll();
		System.out.println(articles);
		
		
		// System.out.println("Test de find article by id : ");
		// Optional<Article> articleOpt = repoArticle.findById(2);
		// System.out.println(articleOpt);
		
		// Article articleTest = new Article(4, "choco", "barre chocolaté", new Date(), new Date(), 100.00, 200.00, "creer", 1, 1);
		// repoArticle.save(articleTest);
		// System.out.println(articleTest);
		
		// Utilisateur utilisateurTest2 =  new Utilisateur(4, "Jadoe", "Doe", "Janne", "jannedoe@example.com", "0123456789", "anonym", "75001", "Paris", "password123", 101.00, false);
		// repoUtilisateur.update(utilisateurTest2);
		// System.out.println(utilisateurTest2);

		// List<Article> articles2 = repoArticle.findAll();
		// System.out.println(articles2);
	}
}