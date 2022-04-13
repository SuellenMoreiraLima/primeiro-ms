package br.com.nava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dtos.EnderecoDTO;
import br.com.nava.dtos.ProfessorDTO;
import br.com.nava.entities.EnderecoEntity;
import br.com.nava.entities.ProfessorEntity;
import br.com.nava.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<EnderecoDTO> getAll(){
        List<EnderecoEntity> lista =  enderecoRepository.findAll();
		
		List<EnderecoDTO> listaDTO = new ArrayList<>();	
		
for (EnderecoEntity professorEntity : lista) {						
			
			EnderecoDTO dto = new EnderecoDTO();
			
			dto.setId( professorEntity.getId() );
			dto.setRua( professorEntity.getRua());
			dto.setNumero( professorEntity.getNumero());
			dto.setCep( professorEntity.getCep() );
			dto.setCidade( professorEntity.getCidade() );
			dto.setEstado( professorEntity.getEstado() );
			
			listaDTO.add(dto);
} return listaDTO;	}
	
	public EnderecoEntity getOne(int id) {
		return this.enderecoRepository .findById(id)
				.orElse(new EnderecoEntity());
	}

	public EnderecoEntity save(EnderecoEntity endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public EnderecoEntity update(int id, EnderecoEntity novoEndereco) {
		//verificar se o registro existe
		
		Optional<EnderecoEntity> enderecoBD = enderecoRepository.findById(id);
		
		//se o registro existir
		if(enderecoBD.isPresent()) {
			EnderecoEntity obj = enderecoBD.get();
			
			obj.setCep(novoEndereco.getCep());
			obj.setCidade(novoEndereco.getCidade());
			obj.setEstado(novoEndereco.getEstado());
			obj.setNumero(novoEndereco.getNumero());
			obj.setRua(novoEndereco.getRua());
			obj.setUsuario(novoEndereco.getUsuario());
			
			return enderecoRepository.save(obj);		
		}
		else {
			return new EnderecoEntity();
		}
	}
		
		public void delete(int id) {
			enderecoRepository.deleteById(id); 
	}
	
}
