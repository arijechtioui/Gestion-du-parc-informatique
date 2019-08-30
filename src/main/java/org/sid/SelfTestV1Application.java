package org.sid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sid.dao.CategorieRepository;
import org.sid.dao.EmployeRepository;
import org.sid.dao.EtatRepository;
import org.sid.dao.MarqueRepository;
import org.sid.dao.ProduitRepository;
import org.sid.dao.ServiceRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Employe;
import org.sid.entities.Etat;
import org.sid.entities.Marque;
import org.sid.entities.Produit;
import org.sid.entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SelfTestV1Application implements CommandLineRunner {
	@Autowired
private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private EtatRepository etatRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private MarqueRepository marqueRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	public static void main(String[] args) {
		SpringApplication.run(SelfTestV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Marque m1= marqueRepository.save(new Marque("hp"));
		Marque m2= marqueRepository.save(new Marque("canon"));
		Marque m3= marqueRepository.save(new Marque("dell"));
		Categorie c1=categorieRepository.save(new Categorie("Ordinateurs"));
		Categorie c2=categorieRepository.save(new Categorie("Imprimantes"));
		Categorie c3=categorieRepository.save(new Categorie("Autres"));

		Service s1=serviceRepository.save(new Service("informatique"));
		Service s2=serviceRepository.save(new Service("electrique"));
		
		Employe emp1=employeRepository.save(new Employe("arije","chtioui","02142588","99001236",s1));
		Employe emp2=employeRepository.save(new Employe("rayyen","chtioui","02145878","98901236",s2));
		Etat e1=etatRepository.save(new Etat("ok"));
		Etat e2=etatRepository.save(new Etat("en panne"));
		
		
            Produit p1=new Produit("erer1","eee","fff",new Date(),m1);p1.setCategorie(c1);
            p1.setEtat(e2);p1.setEmploye(emp1);
            Produit p2=new Produit("erer2","eee","zzz",new Date(),m2);p2.setEtat(e2);
            p2.setCategorie(c1);p2.setEmploye(emp2);
            Produit p3=new Produit("erer3","eee","zzz",new Date(),m1);p3.setEtat(e1);
            p3.setCategorie(c1);p3.setEmploye(emp1);
            Produit p12=new Produit("erer1","eee","zzz",new Date(),m3); p12.setEtat(e1);
            p12.setCategorie(c2);p12.setEmploye(emp2);
            Produit p22=new Produit("erer2","eee","zzz",new Date(),m1); p22.setEtat(e1);
            p22.setCategorie(c2);p22.setEmploye(emp1);
            Produit p33=new Produit("erer3","eee","zzz",new Date(),m3);
            p33.setCategorie(c3);p33.setEmploye(emp2);
            produitRepository.save(p1);produitRepository.save(p2);produitRepository.save(p3);
            produitRepository.save(p12);produitRepository.save(p22);
            produitRepository.save(p33);
		
	}

}
