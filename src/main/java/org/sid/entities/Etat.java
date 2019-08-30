package org.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Etat {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idE;
	private String nomE;
	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "etat")
	private List<Produit> produits;
	public Long getIdE() {
		return idE;
	}
	public void setIdE(Long idE) {
		this.idE = idE;
	}
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public Etat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etat(String nomE) {
		super();
		this.nomE = nomE;
	}
	
}
