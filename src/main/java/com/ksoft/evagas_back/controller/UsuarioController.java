package com.ksoft.evagas_back.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksoft.evagas_back.domain.usuario.UsuarioDto;
import com.ksoft.evagas_back.service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping
	public ResponseEntity<?> getUsuarios() 
	{
		List<UsuarioDto> usuarios = usuariosService.getUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping
	public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioDto usuario){
		UsuarioDto usuarioSalvo = usuariosService.salvarUsuario(usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizarUsuario(@RequestBody UsuarioDto usuario){
		UsuarioDto usuarioAtualizado = usuariosService.atualizarUsuario(usuario);
		return ResponseEntity.ok(usuarioAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
		usuariosService.deletarUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id){
		Optional<UsuarioDto> usuario = usuariosService.getUsuarioById(id);
		if(usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	

}
