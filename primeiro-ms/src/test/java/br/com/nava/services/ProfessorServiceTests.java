package br.com.nava.services;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
		
		List<Professor>
		
		professorService.getAll();
		
	}
	
}