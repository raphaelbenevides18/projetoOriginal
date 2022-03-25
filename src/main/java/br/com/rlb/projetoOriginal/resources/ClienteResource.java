package br.com.rlb.projetoOriginal.resources;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlb.projetoOriginal.dto.ClienteNewDTO;
import br.com.rlb.projetoOriginal.entity.Cliente;
import br.com.rlb.projetoOriginal.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
	@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@ApiOperation(value= "Rest de teste")
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public String listar() {

		String msg = "REST funcionando";

		return msg;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Long id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value= "Listar todos os clientes")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method=RequestMethod.POST,produces =
			MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insert(@RequestBody ClienteNewDTO objDto) {
		try {
			//Pega os dados do DTO e coloca no obj Cliente de forma correta
			Cliente obj = service.fromDTO(objDto);
			service.insert(obj); // Gravo o principal
			
			return ResponseEntity.ok().build();
			} catch (Exception ex) {
				return new ResponseEntity<String>("Error :" +
						ex.getMessage(), HttpStatus.BAD_REQUEST);
			}
			
	}
	
	//DOING...
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ClienteNewDTO objDto, @PathVariable Long id) {
		Cliente obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return new ResponseEntity<String>("Error :" +
					ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

}
