package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.sid.dao.EmployeRepository;

import org.sid.dao.ProduitRepository;
import org.sid.dao.ServiceRepository;
import org.sid.entities.Employe;
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
public class EmployeController {
	@Autowired
private ProduitRepository produitRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@GetMapping ("/user/emp")
	public String prem (Model model,@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="motCle", defaultValue="") String mc ) {
		 Page <Employe> pageEmployes=
				 employeRepository.findByNomContains(mc,PageRequest.of(page,4));
		 model.addAttribute("listProducts", pageEmployes.getContent());
			model.addAttribute("pages", new int [pageEmployes.getTotalPages()]);
			model.addAttribute("currentPage",page);
			model.addAttribute("motCle",mc);
		return "employe";
	}
	@GetMapping("/admin/deleteEmp")
	public String delete(Long id ,int page,String motCle) {
		employeRepository.deleteById(id);
		return "redirect:/user/emp?page="+page+"&motCle="+motCle; 
	}
	@GetMapping("/admin/editEmp")
	public String edit(Model model,Long id) {
		Employe emp=employeRepository.findById(id).get();
		model.addAttribute("employe", emp);
	
		List <Service> s=serviceRepository.findAll();
		model.addAttribute("listServices", s);
		return "EditEmp"; 
	}
	@PostMapping("/admin/saveEmp")
	public String save(Model model,@Valid Employe employe,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formEmp";
		employeRepository.save(employe);
		return "redirect:/user/emp"; 
	}
	@GetMapping("/admin/formEmp")
	public String form(Model model,Long id) {
		model.addAttribute("employe",new Employe());
		List<Service> service =serviceRepository.findAll();
		model.addAttribute("listServices", service);

		return "formEmp"; } 
}
