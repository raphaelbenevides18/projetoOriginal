package br.com.rlb.projetoOriginal.entity;

import java.io.Serializable;

public class CepResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 private String logradouro;
	 private String bairro;
	 
	 public CepResponse() {
		
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	 
	 
}
