package org.sid.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Produit {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	private String numSerie,modele,observation;
	private Date dateCreation=new Date();
	 @ManyToOne @JoinColumn(name = "cat_id") 
	private Categorie categorie;
	 @ManyToOne @JoinColumn(name = "emp_id") 
	 private Employe employe;
	 
	 @ManyToOne @JoinColumn(name = "etat_id") 
	 private Etat etat;
	 @ManyToOne @JoinColumn(name = "marq_id") 
	 private Marque marque;

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(String numSerie, String modele, String observation, Date dateCreation,Marque marque) {
		super();
		this.numSerie = numSerie;
		this.modele = modele;
		this.observation = observation;
		this.dateCreation = dateCreation;
		this.marque=marque;
	}
	 
}
