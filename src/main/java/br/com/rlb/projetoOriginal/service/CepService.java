package br.com.rlb.projetoOriginal.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rlb.projetoOriginal.entity.CepResponse;
import feign.Response;

@FeignClient(name = "cepService", url = "https://api.postmon.com.br")
public interface CepService {
 
 @RequestMapping(value="/cep/{cep}", method = RequestMethod.GET, 
		 produces = MediaType.APPLICATION_JSON_VALUE, 
		 consumes = MediaType.APPLICATION_JSON_VALUE)
 public CepResponse getCep(@PathVariable("cep") String cep);
}
