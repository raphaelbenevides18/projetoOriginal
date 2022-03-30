package br.com.rlb.projetoOriginal.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.rlb.projetoOriginal.entity.Cliente;
import br.com.rlb.projetoOriginal.repository.ClienteRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClienteReourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
    ClienteRepository dao;
	 
	@Test
    public void listar() throws Exception {
		
        mockMvc.perform(get("/clientes/listar")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("REST funcionando"));
    }
	
	@Test
    public void deveRetornar_TodaLista() throws Exception {
		
        mockMvc.perform(get("/clientes/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE));
    }
	
	@Test
    public void deveRetornar_UmRegistro() throws Exception {
		//Cliente cli = new Cliente(1L, "Raphael", "meuemail@gmail");
	        //Mockito.when(ClienteRepository.cl(1)).thenReturn(item);
       // mockMvc.perform(get("/clientes/1")
               // .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isOk());
                //.andExpect(content().json("[]"));
    }

}
