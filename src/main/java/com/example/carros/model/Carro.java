package com.example.carros.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carro{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private Integer ano_fabricacao;
	
	@ManyToOne
    @JoinColumn(name = "conc_id")
	private Concessionaria concessionaria;
	
	@ManyToOne
    @JoinColumn(name = "pro_id")
	private Proprietario proprietario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(Integer ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public Concessionaria getConcessionaria() {
		return concessionaria;
	}
	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
}