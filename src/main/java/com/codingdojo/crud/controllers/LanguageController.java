package com.codingdojo.crud.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.crud.models.Language;
import com.codingdojo.crud.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {

	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("")
	public String index(Model model) {
		if (!model.containsAttribute("language")) {
			model.addAttribute("language", new Language());
		}
		model.addAttribute("languages", languageService.getAll());
		return "index.jsp";
	}

	@PostMapping(value = "/new")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.language", bindingResult);
			redirectAttributes.addFlashAttribute("language", language);
			return "redirect:/languages";
		}
		languageService.create(language);
		redirectAttributes.addFlashAttribute("success", "Language has been created");
		return "redirect:/languages";
	}

	@DeleteMapping(value = "/delete/{id}")
	public String destroy(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		languageService.delete(id);
		redirectAttributes.addFlashAttribute("success", "language has been deleted");
		return "redirect:/languages";
	}
	
	@GetMapping("/edit/{id}")
	public String displaypUpdatePage(@PathVariable("id") Long id, Model model) {
		if (!model.containsAttribute("language")) {
			model.addAttribute("language", languageService.findLanguageById(id));
		}
		model.addAttribute("languageId", id);
		return "edit.jsp";
	}

	@PutMapping(value = "/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("language") Language language,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.language", bindingResult);
			redirectAttributes.addFlashAttribute("language", language);
			return "redirect:/languages/edit/{id}";
		}
		languageService.update(id, language);
		redirectAttributes.addFlashAttribute("success", "Language has been updated");
		model.addAttribute("language", languageService.findLanguageById(id));
		return "redirect:/languages";
	}
	
	@GetMapping("/{id}")
	public String readOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.findLanguageById(id));
		return "details.jsp";
	}

}
