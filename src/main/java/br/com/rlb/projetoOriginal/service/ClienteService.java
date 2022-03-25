package br.com.rlb.projetoOriginal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rlb.projetoOriginal.entity.Cliente;
import br.com.rlb.projetoOriginal.repository.ClienteRepository;
import br.com.rlb.projetoOriginal.repository.EnderecoRepository;
import br.com.rlb.projetoOriginal.service.exception.ObjectNotFoundException;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository dao;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente findById(Long id) {
		
		Optional<Cliente> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	
	public List<Cliente> findAll(){
		return dao.findAll();
	}

}
