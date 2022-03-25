package br.com.rlb.projetoOriginal.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String email;
	
	private String cep;

	public ClienteDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
