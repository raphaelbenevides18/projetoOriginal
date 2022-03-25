package br.com.rlb.projetoOriginal.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlb.projetoOriginal.entity.Cliente;
import br.com.rlb.projetoOriginal.entity.Endereco;
import br.com.rlb.projetoOriginal.service.ClienteService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces="application/json")
	public String listar() {
		
		String msg = "REST funcionando";
		
		return msg;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Long id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		//Endereco end1 = new Endereco();
		//Endereco end2 = new Endereco();
		
		//List<Endereco> listaEnd = new ArrayList<>();
		// listaEnd.add(end1);
		// listaEnd.add(end2); 
		
		//Cliente cl1 = new Cliente(1,"Raphael Benevides","raphael@hotmail.com",listaEnd);
		
		List<Cliente> list = service.findAll();
	
		return ResponseEntity.ok().body(list);
	}
	

}
