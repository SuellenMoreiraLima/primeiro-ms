package br.com.nava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.ProfessorEntity;
import br.com.nava.entities.UsuarioEntity;
import br.com.nava.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void mostrar() {
		System.out.println("mostrar");
	}
	
	public List<UsuarioEntity> getAll(){
		return usuarioRepository.findAll();	
		}
	
	public UsuarioEntity getOne(int id) {
		
		Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
		
		UsuarioEntity usuario = optional.orElse(new UsuarioEntity());
		
		return usuario;
	}
	public UsuarioEntity save(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public UsuarioEntity update(int id, UsuarioEntity usuario) {
		
		// primeiro passo é verificar se o registro existe no banco de dados
		
		Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
		// se existe no banco de dados
		if (optional.isPresent() == true) {
			// atualiza o objeto existente
			UsuarioEntity usuarioBD = optional.get();
			usuarioBD.setNome( usuario.getNome());
			usuarioBD.setEmail( usuario.getEmail());
			usuarioBD.setEndereco(usuario.getEndereco());
			
			return usuarioRepository.save(usuarioBD);
		}
		// caso contrário, retorna um objeto vazio
		else {
			return new UsuarioEntity();
		}
	}
	
	public void delete(int id) {
		
		usuarioRepository.deleteById(id);
	}
	
	
}
