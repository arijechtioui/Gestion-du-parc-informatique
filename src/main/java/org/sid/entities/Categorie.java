package org.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Categorie {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "categorie")
	private List<Produit> produits;


public Long getIdCat() {
	return idCat;
}


public void setIdCat(Long idCat) {
	this.idCat = idCat;
}


public String getNomCat() {
	return nomCat;
}


public void setNomCat(String nomCat) {
	this.nomCat = nomCat;
}


public List<Produit> getProduits() {
	return produits;
}


public void setProduits(List<Produit> produits) {
	this.produits = produits;
}
public Categorie() {
	super();
	// TODO Auto-generated constructor stub
}


public Categorie(String nomCat) {
	super();
	this.nomCat = nomCat;
}

}
