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

import com.example.carros.repository.Proprietarios;
import com.example.carros.model.Proprietario;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/proprietarios")
public class ProprietariosController {

	@Autowired
	private Proprietarios proprietarios;


	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaProprietarios");
		mv.addObject(new Proprietario());
		mv.addObject("proprietarios", proprietarios.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Proprietario proprietario) {
		proprietarios.save(proprietario);
		return "redirect:/proprietarios";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirProprietarioByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.proprietarios.deleteById(id);
		return "redirect:/proprietarios";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarProprietarioByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaProprietarios");
		Proprietario proprietario = (Proprietario) proprietarios.getOne(id);
		mv.addObject(proprietario);
		mv.addObject("proprietarios", proprietarios.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}

