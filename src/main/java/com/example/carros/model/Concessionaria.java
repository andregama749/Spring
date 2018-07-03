package com.example.carros.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Concessionaria{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer telefone;
	
	@OneToMany(mappedBy = "concessionaria", cascade = CascadeType.ALL)
	private Set<Carro> carros;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Set<Carro> getCarros() {
		return carros;
	}
	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}
	
	

	
	
	
}