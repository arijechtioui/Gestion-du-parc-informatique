package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.sid.dao.MarqueRepository;

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
public class MarqueController {
	@Autowired
	private MarqueRepository marqueRepository;
	@GetMapping ("/user/marq")
	public String premm(Model model,@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="motCle", defaultValue="") String mc ) {
		 Page <Marque> pageMarques=
				 marqueRepository.findByNomMarqContains(mc,PageRequest.of(page,4));
		 model.addAttribute("listProducts",pageMarques.getContent());
			model.addAttribute("pages", new int [pageMarques.getTotalPages()]);
			model.addAttribute("currentPage",page);
			model.addAttribute("motCle",mc);
		return "marque";
	}
	@GetMapping("/admin/deleteMarq")
	public String deletem(Long id ,int page,String motCle) {
		marqueRepository.deleteById(id);
		return "redirect:/user/marq?pageM="+page+"&motCle="+motCle; 
	}
	@GetMapping("/admin/editMarq")
	public String editm(Model model,Long id) {
		Marque marque=marqueRepository.findById(id).get();
		model.addAttribute("marque", marque);
		return "EditMarq"; 
	}
	@PostMapping("/admin/saveMarq")
	public String savem(Model model,@Valid Marque marque,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formMarque";
		marqueRepository.save(marque);
		return "redirect:/user/marq"; 
	}
	
	@GetMapping("/admin/formMarq")
	public String formm(Model model,Long id) {
		model.addAttribute("marque",new Marque());
		List<Marque> marques=marqueRepository.findAll();
		model.addAttribute("listMarques", marques);
		return "formMarq"; } 
}
