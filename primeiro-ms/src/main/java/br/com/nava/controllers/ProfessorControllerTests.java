package br.com.nava.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nava.dtos.ProfessorDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfessorControllerTests {

	// temos que fazer as requisições para os endpoints do controller
	//que queremos testar.
	
	// responsável por criar as requisições REST para a camada de Controller
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getAllTest() throws Exception {
		
		// armazena o objeto que fará o test e colher o resultado
		ResultActions response = mockMvc.perform(
											get("/professores")
											.contentType("application/json")
										);
		// pegando o resultado via MvcResult
		MvcResult result = response.andReturn();
		// pegando o resultado no formato de String
		String responseStr = result.getResponse().getContentAsString();
		
		System.out.println(responseStr);
		
		ObjectMapper mapper = new ObjectMapper();
		// convert o resultado de String em um Array de Objetos de Professor DTO
		ProfessorDTO[] lista = mapper.readValue(responseStr, ProfessorDTO[].class);
		// verificando se a lista de retorno não é vazia
		assertThat(lista).isNotEmpty();
	}
	
	@Test
	void getOneTest() throws Exception {
		// armazena o objeto que fará o test e colher o resultado
		ResultActions response = mockMvc.perform(
											get("/professores/1")
											.contentType("application/json")
										);
		
		// pegando o resultado via MvcResult
		MvcResult result = response.andReturn();
		// pegando o resultado no formato de String
		String responseStr = result.getResponse().getContentAsString();
		
		System.out.println(responseStr);
					
		ObjectMapper mapper = new ObjectMapper();
		
		ProfessorDTO professor = mapper.readValue(responseStr, ProfessorDTO.class);
		
		assertThat( professor.getId() ).isEqualTo(1);
		assertThat( result.getResponse().getStatus() ).isEqualTo( 200 );
	}
	

}