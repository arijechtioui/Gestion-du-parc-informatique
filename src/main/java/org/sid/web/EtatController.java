package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.sid.dao.EtatRepository;
import org.sid.dao.MarqueRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Employe;
import org.sid.entities.Etat;
import org.sid.entities.Marque;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EtatController {
	@Autowired
	private EtatRepository etatRepository;
	@GetMapping ("/user/etat")
	public String prem (Model model,
			@RequestParam(name="motCle", defaultValue="") String mc ) {
		 List <Etat> etats=
				 etatRepository.findAll();
		 model.addAttribute("etats", etats);
		return "etat";
	}
	@GetMapping("/admin/deleteEtat")
	public String delete(Long id ) {
		etatRepository.deleteById(id);
		return "redirect:/user/etat"; 
	}
	@GetMapping("/admin/editEtat")
	public String edit(Model model,Long id) {
		Etat etat=etatRepository.findById(id).get();
		model.addAttribute("etat",etat);
		return "EditEtat"; 
	}
	@PostMapping("/admin/saveEtat")
	public String save(Model model,@Valid Etat etat ,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formProduit";
		etatRepository.save(etat);
		return "redirect:/user/etat"; 
	}
	@GetMapping("/admin/formEtat")
	public String form(Model model,Long id) {
		model.addAttribute("etat",new Etat());
		
		List<Etat>e=etatRepository.findAll();
	
		model.addAttribute("listEtat", e);

		return "formEtat"; } 
	

}
