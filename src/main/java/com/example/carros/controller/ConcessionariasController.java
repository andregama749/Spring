package com.example.carros.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.carros.model.Concessionaria;
import com.example.carros.repository.Concessionarias;


import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/concessionarias")
public class ConcessionariasController {

	@Autowired
	private Concessionarias concessionarias;


	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConcessionarias");
		mv.addObject(new Concessionaria());
		mv.addObject("concessionarias", concessionarias.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Concessionaria concessionaria) {
		concessionarias.save(concessionaria);
		return "redirect:/concessionarias";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirConcessionariaByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
		this.concessionarias.deleteById(id);
		return "redirect:/concessionarias";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarConcessionariaByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("ListaConcessionarias");
		Concessionaria concessionaria = (Concessionaria) concessionarias.getOne(id);
		mv.addObject(concessionaria);
		mv.addObject("concessionarias", concessionarias.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}

