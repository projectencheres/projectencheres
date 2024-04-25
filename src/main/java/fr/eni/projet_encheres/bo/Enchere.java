package fr.eni.projet_encheres.bo;

import java.util.Date;


public class Enchere {
    private int noEnchere;
    private Date dateEnchere;
    private Double montantEnchere;
	private Article article;
	private Utilisateur utilisateur;

	public Enchere() {}

	public Enchere(int noEnchere, Date dateEnchere, Double montantEnchere, Article article, Utilisateur utilisateur) {
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.utilisateur = utilisateur;
	}

	// Getters and Setters
    
	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Double getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(Double montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
