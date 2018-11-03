package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.AuthorRespository;

@Controller
public class AuthorController {
	
	private AuthorRespository authorRespository;
	
	public AuthorController(AuthorRespository authorRespository) {
		this.authorRespository=authorRespository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRespository.findAll());
		return "authors";
	}

}
