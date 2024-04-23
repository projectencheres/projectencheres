package fr.eni.projet_encheres.bo;

import java.util.Date;

public class Article {
    private int noArticle;
    private String nomArticle;
    private String description;
    private Date dateDebutEncheres;
    private Date dateFinEncheres;
    private Double miseAPrix;
    private Double prixVente;
    private String etatVente;
    private int categorieArticle;
    private int lieuRetrait;
    
    // Getters and Setters
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public Double getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(Double miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public Double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	public int getCategorieArticle() {
		return categorieArticle;
	}
	public void setCategorieArticle(int categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	public int getLieuRetrait() {
		return lieuRetrait;
	}
	public void setLieuRetrait(int lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
    
}

