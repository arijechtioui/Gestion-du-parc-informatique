package org.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Employe {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmp;
	private String nom,prenom;
	private String cin;
	private String tel;
	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "employe")
	private List<Produit> produits;
	@ManyToOne @JoinColumn(name = "service_id") 
	private Service serviceEmp;
	public Long getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(Long idEmp) {
		this.idEmp = idEmp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public Service getServiceEmp() {
		return serviceEmp;
	}
	public void setServiceEmp(Service serviceEmp) {
		this.serviceEmp = serviceEmp;
	}
	public Employe(String nom, String prenom, String cin, String tel,Service serviceEmp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tel = tel;
		this.serviceEmp=serviceEmp;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
