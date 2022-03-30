package br.com.rlb.projetoOriginal.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.rlb.projetoOriginal.AppConfig;
import br.com.rlb.projetoOriginal.entity.Cliente;
import br.com.rlb.projetoOriginal.entity.Endereco;
import br.com.rlb.projetoOriginal.repository.ClienteRepository;
import br.com.rlb.projetoOriginal.service.exception.ObjectNotFoundException;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {
	
	@InjectMocks
	private ClienteService service;
	
	@Mock
	private ClienteRepository dao;
	
	@Test
	public void deveRetornar_UmRegistro(){
		
		Optional<Cliente> objEsperado = setCLiente();
			
			Mockito.when(dao.findById(ArgumentMatchers.anyLong())).thenReturn(objEsperado);
			
			Cliente objRetornado = service.findById(ArgumentMatchers.anyLong());
			
			Optional<Cliente> objRetornadoOptional = Optional.of(objRetornado);
			
			Assert.assertEquals(objEsperado, objRetornadoOptional);
			
	}
	
	//@Test
//	public void deveRetornar_ClienteNaoEncntrado(){
		
		//ClienteService service = Mockito.mock(ClienteService.class);
		//ClienteRepository dao = Mockito.mock(ClienteRepository.class);
		
			//Cliente obj = new Cliente();
			//obj = service.findById(18788L);
			
			//assertEquals("Raphael Benevides", obj.getNome());
			//try {
			//	service.findById(7878L);
			//} catch (ObjectNotFoundException ex) {
			//	assertEquals("Objeto não encontrado! Id: "+ 123456L, ex.getMessage());
			//}
		
	//}
	
	private Optional<Cliente> setCLiente() {
		Long id = 123456L;
		String nome = "Raphael Benevides";
		String email = "raphael.benevides@gmail.com";
		
		//Optional<Cliente> cli;
		Endereco end1 = new Endereco();
		Endereco end2 = new Endereco();
		
		end1.setId(987654L);
		end1.setCep("24120210");
		end1.setLogradouro("Rua das coves");
		//end1.setCliente(cli1);
		
		end2.setId(999888L);
		end2.setCep("24130200");
		end2.setLogradouro("Rua Dalvo Rabello");
		//end2.setCliente(cli1);
		
		List<Endereco> enderecoList = new ArrayList<Endereco>();
		enderecoList.add(end1);
		enderecoList.add(end2);
		
		Cliente cli1 = new Cliente();
		cli1.setId(id);
		cli1.setNome(nome);
		cli1.setEmail(email);
		cli1.setEnderecos(enderecoList);
		
		Optional<Cliente> cli = Optional.of(cli1);
		
		return cli;
		
		
	}

}
