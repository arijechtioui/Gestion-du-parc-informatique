package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.sid.dao.EtatRepository;
import org.sid.dao.MarqueRepository;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiceController {
	@Autowired
	private ServiceRepository serviceRepository;
	@GetMapping ("/user/service")
	public String prem (Model model,
			@RequestParam(name="motCle", defaultValue="") String mc ) {
		 List <Service> etats=
				 serviceRepository.findAll();
		 model.addAttribute("services", etats);
		return "service";
	}
	@GetMapping("/admin/deleteSer")
	public String delete(Long id ) {
		serviceRepository.deleteById(id);
		return "redirect:/user/service"; 
	}
	@GetMapping("/admin/editSer")
	public String edit(Model model,Long id) {
		Service etat=serviceRepository.findById(id).get();
		model.addAttribute("service",etat);
		return "EditService"; 
	}
	@PostMapping("/admin/saveSer")
	public String save(Model model,@Valid Service service ,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formService";
		serviceRepository.save(service);
		return "redirect:/user/service"; 
	}
	@GetMapping("/admin/formSer")
	public String form(Model model,Long id) {
		model.addAttribute("service",new Service());
		List<Service>e=serviceRepository.findAll();
		model.addAttribute("listSer", e);
		return "formService"; } 
	

}
