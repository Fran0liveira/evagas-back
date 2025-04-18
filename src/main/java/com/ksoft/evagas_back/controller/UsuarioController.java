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
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println("BUSCANDO: ");
		List<UsuarioDto> usuarios = usuariosService.getUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping
	public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioDto usuario){
		System.out.println("SALVANDO " + usuario.getRoles());
		UsuarioDto usuarioSalvo = usuariosService.salvarUsuario(usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizarUsuario(@RequestBody UsuarioDto usuario){
		System.out.println("SALVANDO " + usuario.getRoles().toString());
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
		System.out.println("ID: " + id);
		return usuariosService.getUsuarioById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> getUsuarioByQueryParams(@RequestParam("email") String email){
		System.out.println("EMAIL: " + email);
		return usuariosService
				.getUsuarioByEmail(email)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	

}
