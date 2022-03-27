package br.com.rlb.projetoOriginal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import br.com.rlb.projetoOriginal.dto.ClienteNewDTO;
import br.com.rlb.projetoOriginal.entity.CepResponse;
import br.com.rlb.projetoOriginal.entity.Cliente;
import br.com.rlb.projetoOriginal.entity.Endereco;
import br.com.rlb.projetoOriginal.repository.ClienteRepository;
import br.com.rlb.projetoOriginal.repository.EnderecoRepository;
import br.com.rlb.projetoOriginal.service.exception.ObjectNotFoundException;







@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository dao;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private  CepService cepService;
	
	public Cliente findById(Long id) {
		
		Optional<Cliente> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	
	public List<Cliente> findAll(){
		return dao.findAll();
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = dao.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return dao.save(newObj);
	}
	
	public void delete(Long id) throws Exception {
		findById(id);
		try {
			dao.deleteById(id);
		} catch (Exception  ex) {
			throw new Exception(ex.getMessage());
			
		}
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail());
		if(objDto.getCep() != null) {
			CepResponse endAPI = cepService.getCep(objDto.getCep());
			Endereco end = new Endereco(null, endAPI.getLogradouro(), endAPI.getBairro(), objDto.getCep(), cli);
			cli.getEnderecos().add(end);
			System.out.println(endAPI);
		}else {
			Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getBairro(), objDto.getCep(), cli);
			cli.getEnderecos().add(end);
		}
		
		
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setEnderecos(obj.getEnderecos());
	}

}
