package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.sid.dao.CategorieRepository;
import org.sid.dao.EtatRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Etat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategorieController {
	@Autowired
	private CategorieRepository categorieRepository;
	@GetMapping ("/user/cat")
	public String prem (Model model,
			@RequestParam(name="motCle", defaultValue="") String mc ) {
		 List <Categorie> etats=
				 categorieRepository.findAll();
		 model.addAttribute("categories", etats);
		return "categorie";
	}
	@GetMapping("/admin/deleteCat")
	public String delete(Long id ) {
		categorieRepository.deleteById(id);
		return "redirect:/user/cat"; 
	}
	@GetMapping("/admin/editCat")
	public String edit(Model model,Long id) {
		Categorie etat=categorieRepository.findById(id).get();
		model.addAttribute("categorie",etat);
		return "EditCat"; 
	}
	@PostMapping("/admin/saveCat")
	public String save(Model model,@Valid Categorie categorie ,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formCat";
		categorieRepository.save(categorie);
		return "redirect:/user/cat"; 
	}
	@GetMapping("/admin/formCat")
	public String form(Model model,Long id) {
		model.addAttribute("categorie",new Categorie());
		
		List<Categorie>e=categorieRepository.findAll();
	
		model.addAttribute("listCat", e);

		return "formCat"; } 

}
