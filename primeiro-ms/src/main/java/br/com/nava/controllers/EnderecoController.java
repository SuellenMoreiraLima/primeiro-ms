package br.com.nava.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.dtos.EnderecoDTO;
import br.com.nava.entities.EnderecoEntity;
import br.com.nava.services.EnderecoService;
import br.com.nava.repositories.EnderecoRepository;

@RestController
@RequestMapping(value = "enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("")
	public ResponseEntity<List<EnderecoDTO>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getAll());

	} 
	
	@GetMapping("{id}")
	public ResponseEntity<EnderecoEntity> getOne(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getOne(id));
	}
	
	@PostMapping
	public ResponseEntity<EnderecoEntity> save(@Valid @RequestBody EnderecoDTO endereco) {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco.toEntity()));
		
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<EnderecoEntity> update(@PathVariable int id, @RequestBody EnderecoDTO endereco) {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.update(id, endereco.toEntity()));		
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable int id) {
		enderecoService.delete(id);
	}
	
}
