package com.uia.patientmanager.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uia.patientmanager.dao.PatientRepository;
import com.uia.patientmanager.entities.Patient;

@Controller
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository; 
	
	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "formPatient";
	}
	
	@GetMapping(path = "/editPatient")
	public String editPatient(Long id, Model model) {
		Patient p = patientRepository.findById(id).get();
		model.addAttribute("patient", p);
		return "formPatient";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(Patient patient) {
		patientRepository.save(patient);
		return "redirect:/patients";	
	}
	
	@GetMapping(path = "/deletePatient")
	public String delete(Long id, String keyword, int size, int page, Model model) {
		patientRepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
		//return patients(model, page, size, keyword);
	}
	
	@GetMapping(path = "/patients")
	public String patients(Model model,
			@RequestParam(name="page", defaultValue = "0")int page,
			@RequestParam(name="size", defaultValue = "5")int size,
			@RequestParam(name="keyword", defaultValue = "")String mc) {
		Page<Patient> pagePatients = patientRepository.findByNameContains(mc, PageRequest.of(page, size));
		model.addAttribute("patients", pagePatients.getContent());
		model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		return "patients";
	}

	
	
}
