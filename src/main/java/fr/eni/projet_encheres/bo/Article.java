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
	
    
    public Article() {
	}
	public Article(int noArticle, String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			Double miseAPrix, Double prixVente, String etatVente, int categorieArticle, int lieuRetrait) {
				super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorieArticle = categorieArticle;
		this.lieuRetrait = lieuRetrait;
	}
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
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", categorieArticle="
				+ categorieArticle + ", lieuRetrait=" + lieuRetrait + "]";
	}
    
}

