package org.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Service {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomSer;
	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "serviceEmp")
	private List<Employe> employes;
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomSer() {
		return nomSer;
	}
	public void setNomSer(String nomSer) {
		this.nomSer = nomSer;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Service(String nomSer) {
		super();
		this.nomSer = nomSer;
	}
	
	
}
