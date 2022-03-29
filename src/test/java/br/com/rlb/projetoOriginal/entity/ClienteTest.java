package br.com.rlb.projetoOriginal.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.rlb.projetoOriginal.AppConfig;

@SpringBootTest(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteTest {
	
	@Test
	public void deveRetornarCliente(){
		
		Long id = 123456L;
		String nome = "Raphael Benevides";
		String email = "raphael.benevides@gmail.com";
		
		Cliente cli = new Cliente();
		Endereco end = new Endereco();
		Endereco end2 = new Endereco();
		
		end.setId(987654L);
		end.setCep("24120210");
		end.setLogradouro("Rua das coves");
		end.setCliente(cli);
		
		end2.setId(999888L);
		end2.setCep("24130200");
		end2.setLogradouro("Rua Dalvo Rabello");
		end2.setCliente(cli);
		
		List<Endereco> enderecoList = new ArrayList<Endereco>();
		enderecoList.add(end);
		enderecoList.add(end2);
		
		cli.setId(id);
		cli.setNome(nome);
		cli.setEmail(email);
		cli.setEnderecos(enderecoList);
		
		assertNotNull(cli);
		assertEquals(nome, cli.getNome());
		assertEquals(email, cli.getEmail());
		assertEquals(enderecoList, cli.getEnderecos());
		
	}

}
