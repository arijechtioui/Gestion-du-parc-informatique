package org.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Marque {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMarq;
	private String nomMarq;
	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "marque")
private List<Produit> produits;
	public Long getIdMarq() {
		return idMarq;
	}
	public void setIdMarq(Long idMarq) {
		this.idMarq = idMarq;
	}
	public String getNomMarq() {
		return nomMarq;
	}
	public void setNomMarq(String nomMarq) {
		this.nomMarq = nomMarq;
	}
	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Marque(String nomMarq) {
		super();
		this.nomMarq = nomMarq;
	}
	
	
}
