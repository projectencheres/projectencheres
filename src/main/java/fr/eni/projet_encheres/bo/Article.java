package fr.eni.projet_encheres.bo;

import java.util.Date;
import java.math.BigDecimal;

public class Article {
    private Long noArticle;
    private String nomArticle;
    private String description;
    private Date dateDebutEncheres;
    private Date dateFinEncheres;
    private BigDecimal miseAPrix;
    private BigDecimal prixVente;
    private String etatVente;
    private Long categorieArticle;
    private Long lieuRetrait;
    
    // Getters and Setters
	public Long getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(Long noArticle) {
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
	public BigDecimal getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(BigDecimal miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public BigDecimal getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(BigDecimal prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	public Long getCategorieArticle() {
		return categorieArticle;
	}
	public void setCategorieArticle(Long categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	public Long getLieuRetrait() {
		return lieuRetrait;
	}
	public void setLieuRetrait(Long lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
    
}

