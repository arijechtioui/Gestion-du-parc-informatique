package org.sid.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
    
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
	@GetMapping ("/user/index")
	public String prem (Model model,@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="motCle", defaultValue="") String mc ) {
		 Page <Produit> pageProduits=
				 produitRepository.findByNumSerieContains(mc,PageRequest.of(page,4));
		 model.addAttribute("listProducts", pageProduits.getContent());
			model.addAttribute("pages", new int [pageProduits.getTotalPages()]);
			model.addAttribute("currentPage",page);
			model.addAttribute("motCle",mc);
		return "produit";
	}
	@GetMapping("/admin/delete")
	public String delete(Long id ,int page,String motCle) {
		produitRepository.deleteById(id);
		return "redirect:/user/index?page="+page+"&motCle="+motCle; 
	}
	@GetMapping("/admin/edit")
	public String edit(Model model,Long id) {
		Produit produit=produitRepository.findById(id).get();
		model.addAttribute("produit",produit);
		List <Categorie> Categories=categorieRepository.findAll();
		List<Marque> marques=marqueRepository.findAll();
		List<Employe> emp=employeRepository.findAll();
		List<Etat>e=etatRepository.findAll();
		model.addAttribute("listCategories", Categories);
		model.addAttribute("listMarques", marques);
		model.addAttribute("listEmp", emp);
		model.addAttribute("listEtat", e);
		return "EditProduit"; 
	}
	@PostMapping("/admin/save")
	public String save(Model model,@Valid Produit produit,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formProduit";
		produitRepository.save(produit);
		return "redirect:/user/index"; 
	}
	
	@RequestMapping("/user/home")
	public String home(Model model) {
		List <Categorie> Categories=categorieRepository.findAll();
		List<Marque> marques=marqueRepository.findAll();
		List<Etat>e=etatRepository.findAll();
		List<Service>s=serviceRepository.findAll();
		model.addAttribute("listCategories", Categories);
		model.addAttribute("listMarques", marques);
		model.addAttribute("listEtat", e);
		model.addAttribute("listSr", s);
		return "home";
	}
	  @GetMapping("/user/search")
	  public String index(Long id ,Model model) {
		  List <Produit> Produits=produitRepository.listProduits(id);
		  model.addAttribute("listProduits", Produits);
	  return "homeProdCat"; }
	  @GetMapping("/user/searchM")
	  public String indexM(Long id ,Model model) {
		  List <Produit> Produits=produitRepository.listProduitsM(id);
		  model.addAttribute("listProduitsM", Produits);
	  return "homeProdMarq"; }
	 
	  
	@GetMapping("/admin/formProduit")
		public String form(Model model,Long id) {
			model.addAttribute("produit",new Produit());
			List <Categorie> Categories=categorieRepository.findAll();
			List<Marque> marques=marqueRepository.findAll();
			List<Employe> emp=employeRepository.findAll();
			List<Etat>e=etatRepository.findAll();
			model.addAttribute("listCategories", Categories);
			model.addAttribute("listMarques", marques);
			model.addAttribute("listEmp", emp);
			model.addAttribute("listEtat", e);
			return "formProduit"; } 
	@GetMapping("/")
	public String def() {
		return "redirect:/user/index"; }
	@GetMapping("/403")
	public String notAutorized() {
		return "403"; }
	@GetMapping("/login")
	public String login() {
		return "/login"; }
	
}
