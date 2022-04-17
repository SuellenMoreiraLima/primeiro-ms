package br.com.nava.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.nava.dtos.ProfessorDTO;
import br.com.nava.entities.ProfessorEntity;
import br.com.nava.repositories.ProfessorRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfessorServiceTests {
	
	@Autowired
	private ProfessorService professorService;
	
	
	// a anotação @MockBean serve para sinalizar que iremos 
		// "MOCKAR(SIMULAR) a camada repository"
	@MockBean
	private ProfessorRepository professorRepository;
	
	
	@Test
	void getAllTest() {
		
		
		professorService.getAll();
		
		// vamos criar uma lista de entidade de professor com o objeto
		// de retornar a mesma quando o professorRepository.findAll() 
		// for acionado
	
		List<ProfessorEntity> listaMockada = new ArrayList<ProfessorEntity>();
	
		ProfessorEntity professorEntidade = new ProfessorEntity();
		professorEntidade.setCep("08690330");
		professorEntidade.setNome("Professor Teste");
		professorEntidade.setNumero(3);
		professorEntidade.setRua("Rua de teste");
		professorEntidade.setId(1);
		
		listaMockada.add(professorEntidade);
		
		// quando o repository for acionado, retorno a lista Mockada
		when(professorRepository.findAll()).thenReturn(listaMockada);
		
		List<ProfessorDTO> retorno = professorService.getAll();
		
		assertThat(listaMockada.get(0).getCep()).isEqualTo(retorno.get(0).getCep());
		assertThat(listaMockada.get(0).getNome()).isEqualTo(retorno.get(0).getNome());
		assertThat(listaMockada.get(0).getNumero()).isEqualTo(retorno.get(0).getNumero());
		assertThat(listaMockada.get(0).getRua()).isEqualTo(retorno.get(0).getRua());
		assertThat(listaMockada.get(0).getId()).isEqualTo(retorno.get(0).getId());
		
	}

}
