package br.com.rlb.projetoOriginal.dto;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable{

		private static final long serialVersionUID = 1L;
		
		
		private String nome;
		
		
		private String email;
		
		
		private String logradouro;
		
		
		private String bairro;
		
		
		private String cep;
		

		public ClienteNewDTO() {
		
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
